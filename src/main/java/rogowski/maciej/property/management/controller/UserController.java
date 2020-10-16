package rogowski.maciej.property.management.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import rogowski.maciej.property.management.Service.AnnouncementService;
import rogowski.maciej.property.management.Service.NotificationService;
import rogowski.maciej.property.management.Service.UserService;
import rogowski.maciej.property.management.entity.Notification;
import rogowski.maciej.property.management.entity.NotificationModel;
import rogowski.maciej.property.management.entity.Property;
import rogowski.maciej.property.management.entity.User;
import rogowski.maciej.property.management.entity.UserPasswordModel;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	private AnnouncementService announcementService;
	private NotificationService notificationService;
	
	@Autowired
	public UserController(UserService theUserService, AnnouncementService theAnnouncementService, NotificationService theNotificationService) {
		userService = theUserService;
		announcementService = theAnnouncementService;
		notificationService = theNotificationService;
	}
	
	@GetMapping("/user")
	public String showUser(Authentication authentication, Model theModel, @RequestParam(name="display", required = false) String display){
		if(display != null) {
			if(display.equals("userEdit")) {
				theModel.addAttribute("userInfo", new DisplayParameter("userEdit"));
			}
			if(display.equals("userPass")) {
				theModel.addAttribute("userInfo", new DisplayParameter("userPassword"));
			}
		}else {
			theModel.addAttribute("userInfo", new DisplayParameter("userInfo"));
		}
		User theUser = userService.findById(authentication.getName());
		if (!theModel.containsAttribute("user")) {
	    	theModel.addAttribute("user", theUser);
	    }
		Property theProperty = theUser.getProperty();
		theModel.addAttribute("property", theProperty);	

	    if (!theModel.containsAttribute("userPasswordModel")) {
	    	theModel.addAttribute("userPasswordModel", new UserPasswordModel());
	    }
		return "/user/user";
	}

	@PostMapping("/userUpdate")
	public String updateUser(@ModelAttribute("user") @Valid User theUser, BindingResult bindingResult, RedirectAttributes attr){		
		if(bindingResult.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
			attr.addFlashAttribute("user", theUser);
			return "redirect:/user/user?display=userEdit";
		}else {
			theUser.setPassword(userService.findById(theUser.getLogin()).getPassword());
			theUser.setProperty(userService.findById(theUser.getLogin()).getProperty());
			theUser.setUserPropertyRole(userService.findById(theUser.getLogin()).getUserPropertyRole());
			userService.save(theUser);
			return "redirect:/user/user";
		}
	}
	
	@PostMapping("/userPassword")
	public String changeUserPassword(@ModelAttribute("userPasswordModel") @Valid  UserPasswordModel theUserPasswordModel, BindingResult bindingResult, @ModelAttribute("user") User theUser, RedirectAttributes attr){ 		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		theUser = userService.findById(theUser.getLogin());
		boolean mathches = encoder.matches(theUserPasswordModel.getOldPassword(), theUser.getPassword().substring(8,68));
		if(!bindingResult.hasErrors() && (mathches)){
			theUser.setPassword("{bcrypt}"+encoder.encode(theUserPasswordModel.getConfirmNewPassword()));
			userService.save(theUser);
			return "redirect:/user/user";
		}else {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.userPasswordModel", bindingResult);
			if(mathches != true) {
				theUserPasswordModel.setConfirmOldPassword("Old password mismatch");
			}
			attr.addFlashAttribute("userPasswordModel", theUserPasswordModel);
			return "redirect:/user/user?display=userPass";
		}
	}
	
	@GetMapping("/property")
	public String showProperty(Authentication authentication, Model theModel, @RequestParam(name="display", required = false) String display) {
		Property property = userService.findById(authentication.getName()).getProperty();
		if(display != null) {
			if(display.equals("previous")) {
				theModel.addAttribute("propertyInfo", new DisplayParameter("previous"));
				theModel.addAttribute("announcementList", announcementService.getAnnByLessDate(property.getId()));
			}
			if(display.equals("all")) {
				theModel.addAttribute("propertyInfo", new DisplayParameter("all"));
				theModel.addAttribute("announcementList", announcementService.getAllAnn(property));
			}
			if(display.equals("managers")) {
				theModel.addAttribute("propertyInfo", new DisplayParameter("managers"));
				theModel.addAttribute("managersList", userService.getAllManagersOfProperty(property.getId()));
			}
		}else {
			theModel.addAttribute("propertyInfo", new DisplayParameter("current"));
			theModel.addAttribute("announcementList", announcementService.getAnnByCurrentDate(property.getId()));
		}
		return "/user/property";
	}

	@GetMapping("/notification")
	public String showNotification(Authentication authentication, Model theModel, @RequestParam(name="display", required = false) String display) {
		User theUser = userService.findById(authentication.getName());
		List<NotificationModel> notificationModelList = new ArrayList<>();
	    if (!theModel.containsAttribute("responseNotification")) {
	    	theModel.addAttribute("responseNotification", new Notification());
	    }
		if(display != null && !display.equals("new")) {
			theModel.addAttribute("notifcationUser", theUser);
			if(display.equals("send")) {
				for(Notification n : notificationService.getUserSendNotification(theUser.getLogin(),"admin1")) {
					notificationModelList.add(new NotificationModel(n));
				}
				for(NotificationModel nm : notificationModelList) {
					nm.setNotificationResponseList(notificationService.getResponseNotification(nm.getNotification().getId()));
				}	
				theModel.addAttribute("notificationList", notificationModelList);
				theModel.addAttribute("notificationInfo", new DisplayParameter("send"));
			}
			if(display.equals("all")) {
				for(Notification n : notificationService.getUserNotification(theUser.getLogin(), "admin1")) {
					notificationModelList.add(new NotificationModel(n));
				}
				for(NotificationModel nm : notificationModelList) {
					nm.setNotificationResponseList(notificationService.getResponseNotification(nm.getNotification().getId()));
				}	
				theModel.addAttribute("notificationList", notificationModelList);
				theModel.addAttribute("notificationInfo", new DisplayParameter("all"));
			}
			if(display.equals("newNotif")) {
				theModel.addAttribute("notificationInfo", new DisplayParameter("newNotif"));
			}
		}else {
			for(Notification n : notificationService.getUserNewNotification(theUser.getLogin(),"%","%")) {
				notificationModelList.add(new NotificationModel(n));
			}		
			for(NotificationModel nm : notificationModelList) {
				nm.setNotificationResponseList(notificationService.getResponseNotification(nm.getNotification().getId()));
			}	
			theModel.addAttribute("notificationList", notificationModelList);
			theModel.addAttribute("notificationInfo", new DisplayParameter("new"));
		}
		return "/user/notification";
	}

	@PostMapping("/markNotification")
	public String markNotification(@ModelAttribute("responseNotification") @Valid  Notification notification, BindingResult bindingResult, RedirectAttributes attr) {	
		Notification mainNotification = notificationService.findById(notification.getNotification().getId());
		mainNotification.setNewTO(null);
		notificationService.save(mainNotification);				
		return "redirect:/user/notification?display=new";
	}
	
	@PostMapping("/responseNotification")
	public String responseNotification(Authentication authentication, @ModelAttribute("responseNotification") @Valid  Notification notification, BindingResult bindingResult, RedirectAttributes attr, @RequestParam(name="display", required = true) String display) {
		if(bindingResult.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.responseNotification", bindingResult);
			attr.addFlashAttribute("responseNotification", notification);
			return "redirect:/user/notification?display="+display;
		}else {
			User sender = userService.findById(authentication.getName());
			User receiver = userService.findById("admin1");
			notification.setTitle(notification.getNotification().getTitle());
			notification.setSendDate(LocalDate.now());		
			notification.setSender(sender);
			notification.setReceiver(receiver);	
			notificationService.save(notification);
			Notification changeMark = notificationService.findById(notification.getNotification().getId());
			changeMark.setNewTO(receiver);
			notificationService.save(changeMark);
			return "redirect:/user/notification?display="+display;
		}
	}

	@PostMapping("/saveNotification")
	public String saveNotification(Authentication authentication, @ModelAttribute("responseNotification") @Valid  Notification notification, BindingResult bindingResult, RedirectAttributes attr) {
		if(bindingResult.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.responseNotification", bindingResult);
			attr.addFlashAttribute("responseNotification", notification);
			return "redirect:/user/notification?display=newNotif";
		}else {
			User sender = userService.findById(authentication.getName());
			User receiver = userService.findById("admin1");
			
			notification.setSendDate(LocalDate.now());		
			notification.setSender(sender);
			notification.setReceiver(receiver);	
			notification.setNewTO(receiver);
			notificationService.save(notification);
			return "redirect:/user/notification?display=send";
		}
	}
}
