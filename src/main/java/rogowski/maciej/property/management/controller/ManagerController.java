package rogowski.maciej.property.management.controller;

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
import rogowski.maciej.property.management.Service.PropertyService;
import rogowski.maciej.property.management.Service.RoleService;
import rogowski.maciej.property.management.Service.UserService;
import rogowski.maciej.property.management.entity.Property;
import rogowski.maciej.property.management.entity.Role;
import rogowski.maciej.property.management.entity.User;
import rogowski.maciej.property.management.entity.UserPasswordModel;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	private UserService userService;
	private RoleService roleService;
	private AnnouncementService announcementService;
	private NotificationService notificationService;
	private PropertyService propertyService;
	
	@Autowired
	public ManagerController(UserService theUserService, RoleService theRoleService, AnnouncementService theAnnouncementService, NotificationService theNotificationService, PropertyService thePropertyService) {
		userService = theUserService;
		roleService = theRoleService;
		announcementService = theAnnouncementService;
		notificationService = theNotificationService;
		propertyService = thePropertyService;
	}
	
	@GetMapping("/manager")
	public String showManager(Authentication authentication, Model theModel, @RequestParam(name="display", required = false) String display){
		if(display != null) {
			if(display.equals("userEdit")) {
				theModel.addAttribute("userInfo", new DisplayParameter("userEdit"));
			}
			if(display.equals("userPass")) {
				theModel.addAttribute("userInfo", new DisplayParameter("userPassword"));
			}
			if(display.equals("managerProperty")) {
				theModel.addAttribute("propertyEdit", new Property());
				theModel.addAttribute("userInfo", new DisplayParameter("managerProperty"));
			} 
			if(display.equals("managerPropertyEdit")) {		
				theModel.addAttribute("userInfo", new DisplayParameter("managerPropertyEdit"));
			}
			if(display.equals("managerUser")) {
				theModel.addAttribute("userEdit", new User());
				theModel.addAttribute("userList", userService.findAllPropertyUsers());
				theModel.addAttribute("userInfo", new DisplayParameter("managerUser"));
			}
			if(display.equals("managerUserEdit")) {
				theModel.addAttribute("userInfo", new DisplayParameter("managerUserEdit"));
			}
		}else {
			theModel.addAttribute("userInfo", new DisplayParameter("userInfo"));
		}
		User theUser = userService.findById(authentication.getName());
		if (!theModel.containsAttribute("user")) {
	    	theModel.addAttribute("user", theUser);
	    }
	    if (!theModel.containsAttribute("userPasswordModel")) {
	    	theModel.addAttribute("userPasswordModel", new UserPasswordModel());
	    }
		if (!theModel.containsAttribute("newProperty")) {
	    	theModel.addAttribute("newProperty",  new Property());
	    }	
		theModel.addAttribute("propertyList", propertyService.findAll());	
		User newUser = new User();
		newUser.setProperty(new Property());
		if (!theModel.containsAttribute("newUser")) {
	    	theModel.addAttribute("newUser", newUser);
	    }
		return "/manager/manager";
	}
	
	@PostMapping("/userUpdate")
	public String updateUser(@ModelAttribute("user") @Valid User theUser, BindingResult bindingResult, RedirectAttributes attr){		
		if(bindingResult.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
			attr.addFlashAttribute("user", theUser);
			return "redirect:/manager/manager?display=userEdit";
		}else {
			theUser.setPassword(userService.findById(theUser.getLogin()).getPassword());
			theUser.setUserPropertyRole(userService.findById(theUser.getLogin()).getUserPropertyRole());
			userService.save(theUser);
			return "redirect:/manager/manager";
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
			return "redirect:/manager/manager";
		}else {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.userPasswordModel", bindingResult);
			if(mathches != true) {
				theUserPasswordModel.setConfirmOldPassword("Old password mismatch");
			}
			attr.addFlashAttribute("userPasswordModel", theUserPasswordModel);
			return "redirect:/manager/manager?display=userPass";
		}
	}

	@PostMapping("/propertyShowUpdate")
	public String editProperty(@ModelAttribute("propertyEdit") Property property, RedirectAttributes attr) {
		property = propertyService.findById(property.getId());
		attr.addFlashAttribute("newProperty", property);
		return "redirect:/manager/manager?display=managerPropertyEdit";
	}
	
	@PostMapping("/propertySave")
	public String saveProperty(@ModelAttribute("newProperty") @Valid Property property, BindingResult bindingResult, RedirectAttributes attr) {
		if(bindingResult.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.newProperty", bindingResult);
			attr.addFlashAttribute("newProperty", property);
			return "redirect:/manager/manager?display=managerPropertyEdit";
		}else {
			propertyService.save(property);
			return "redirect:/manager/manager?display=managerProperty";
		}
	}

	@PostMapping("/propertyDelete")
	public String deleteProperty(@ModelAttribute("propertyEdit") Property property) {
		propertyService.delete(propertyService.findById(property.getId()));
		return "redirect:/manager/manager?display=managerProperty";
	}

	@PostMapping("/userShowUpdate")
	public String editUser(@ModelAttribute("userEdit") User user, RedirectAttributes attr) {
		user = userService.findById(user.getLogin());
		attr.addFlashAttribute("newUser", user);
		return "redirect:/manager/manager?display=managerUserEdit";
	}
	
	@PostMapping("/userSave")
	public String saveUser(@ModelAttribute("newUser") @Valid User user, BindingResult bindingResult, RedirectAttributes attr) {	
		user.setProperty(propertyService.findById(user.getProperty().getId()));
		if(bindingResult.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.newUser", bindingResult);
			attr.addFlashAttribute("newUser", user);
			return "redirect:/manager/manager?display=managerUserEdit";
		}else {
			if(!(user.getLogin().equals(""))) {
				user.setPassword(userService.findById(user.getLogin()).getPassword());
				userService.save(user);
			}else {
				user.setLogin(user.getProperty().getName()+(userService.findMaxId(user.getProperty().getId())+1));
				StringBuilder buildPass = new StringBuilder();
				for(int i=0; i< 6; i++) {
					buildPass.append( (  (char)(Math.random()*25 +97)  )+""  );
				}
				String password = buildPass.toString();				
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				user.setPassword("{bcrypt}"+encoder.encode(password));

				userService.save(user);
				userService.addEnableToOne(user.getLogin());
				Role role = new Role();
				role.setUsername(user.getLogin());
				role.setUserRole("ROLE_INHABITANT");
				roleService.save(role);
			}
			return "redirect:/manager/manager?display=managerUser";
		}
	}

	@PostMapping("/useerDelete")
	public String deleteUser(@ModelAttribute("userEdit") User user) {
		userService.delete(userService.findById(user.getLogin()));
		return "redirect:/manager/manager?display=managerUser";
	}
	
	
	
	
}
