package rogowski.maciej.property.management.controller;

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
import rogowski.maciej.property.management.Service.PropertyService;
import rogowski.maciej.property.management.Service.RoleService;
import rogowski.maciej.property.management.Service.UserService;
import rogowski.maciej.property.management.entity.Announcement;
import rogowski.maciej.property.management.entity.GenerateUserModel;
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
				if (!theModel.containsAttribute("userList")) {
					theModel.addAttribute("userList", userService.findAllPropertyUsers());
				}
				theModel.addAttribute("userInfo", new DisplayParameter("managerUser"));
			}
			if(display.equals("managerUserEdit")) {
				theModel.addAttribute("userInfo", new DisplayParameter("managerUserEdit"));
			}
			if(display.equals("generetedInfo")) {
				theModel.addAttribute("userInfo", new DisplayParameter("generetedInfo"));
			}
		}else {
			theModel.addAttribute("userInfo", new DisplayParameter("userInfo"));
		}
		User theUser = userService.findById(authentication.getName());
		if (!theModel.containsAttribute("user")) {
	    	theModel.addAttribute("user", theUser);
	    }
		if (!theModel.containsAttribute("searchUser")) {												
			theModel.addAttribute("searchUser", new User());
		}
		if (!theModel.containsAttribute("searchProperty")) {
			theModel.addAttribute("searchProperty", new Property(0));
		}
	    if (!theModel.containsAttribute("userPasswordModel")) {
	    	theModel.addAttribute("userPasswordModel", new UserPasswordModel());
	    }
		if (!theModel.containsAttribute("newProperty")) {
	    	theModel.addAttribute("newProperty",  new Property());
	    }	
		if (!theModel.containsAttribute("generetedList")) {
	    	theModel.addAttribute("generetedList",  new ArrayList<>());
	    }
		theModel.addAttribute("generateUser", new GenerateUserModel());
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
				return "redirect:/manager/manager?display=managerUser";
			}else {
				user.setLogin(user.getProperty().getName()+(userService.findMaxId(user.getProperty().getId())+1));
				String password = generatePassword();	
				List<String[]> generetedList = new ArrayList<>();
				generetedList.add(new String[]{user.getLogin(), password});
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				user.setPassword("{bcrypt}"+encoder.encode(password));
				createNewUser(user);
				attr.addFlashAttribute("generetedList", generetedList);
				return "redirect:/manager/manager?display=generetedInfo";
			}
		}
	}

	@PostMapping("/useerDelete")
	public String deleteUser(@ModelAttribute("userEdit") User user) {
		userService.delete(userService.findById(user.getLogin()));
		return "redirect:/manager/manager?display=managerUser";
	}
	
	@PostMapping("/generateUser")
	public String generateUser(@ModelAttribute("generateUser") GenerateUserModel generateUserModel, RedirectAttributes attr) {		
		Property property = propertyService.findById(generateUserModel.getProperty().getId());
		List<String[]> generetedList = new ArrayList<>();
		for(int i = 0; i < generateUserModel.getNumberOfUser(); i++) {
			User generatedUser = new User();
			generatedUser.fillGeneratedUserField();
			generatedUser.setProperty(property);
			generatedUser.setLogin(generatedUser.getProperty().getName()+(userService.findMaxId(generatedUser.getProperty().getId())+1));
			String password = generatePassword();
			generetedList.add(new String[]{generatedUser.getLogin(), password});
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			generatedUser.setPassword("{bcrypt}"+encoder.encode(password));		
			createNewUser(generatedUser);
		}
		attr.addFlashAttribute("generetedList", generetedList);
		return "redirect:/manager/manager?display=generetedInfo";
	}

	@PostMapping("/searchUser")
	public String searchUser(@ModelAttribute("searchProperty") Property property, @ModelAttribute("searchUser") User searchUser, RedirectAttributes attr) {	
		if(property.getName().equals("")) {
			property.setName("0");
		}
		if( searchUser.getFirstName() != null && !searchUser.getFirstName().equals("")) {
			String[] string = searchUser.getFirstName().split("\\s");
			if(string.length == 1) {
				string[0] = string[0]+"%";	
				if(!property.getName().equals("0")) {
					attr.addFlashAttribute("userList", userService.searchUserByName(string[0], "%", property.getName()));
				}else {
					attr.addFlashAttribute("userList", userService.searchUserByName(string[0], "%", "%"));
				}	
			}else if(string.length > 1){
				string[0] = string[0]+"%";	
				string[1] = string[1]+"%";	
				if(!property.getName().equals("0")) {
					attr.addFlashAttribute("userList", userService.searchUserByName(string[0], string[1], property.getName()));
				}else {
					attr.addFlashAttribute("userList", userService.searchUserByName(string[0], string[1], "%"));
				}
			}
		}else {
			if(property.getName().equals("0")) {
				attr.addFlashAttribute("userList", userService.searchUserByName("%", "%", "%"));
			}else {
				attr.addFlashAttribute("userList", userService.searchUserByName("%", "%", property.getName()));
			}
		}
		attr.addFlashAttribute("searchProperty", property);
		attr.addFlashAttribute("searchUser", searchUser);	
		return "redirect:/manager/manager?display=managerUser";
	}

	private void createNewUser(User user) {
		userService.save(user);
		userService.addEnableToOne(user.getLogin());
		Role role = new Role();
		role.setUsername(user.getLogin());
		role.setUserRole("ROLE_INHABITANT");
		roleService.save(role);
	}
	
	private String generatePassword() {
		StringBuilder buildPass = new StringBuilder();
		for(int j=0; j< 6; j++) {
			buildPass.append( (  (char)(Math.random()*25 +97)  )+""  );
		}
		return buildPass.toString();		
	}
	
	@GetMapping("/property")
	public String showProperty(Authentication authentication, Model theModel, @RequestParam(name="display", required = false) String display, @RequestParam(name="propertyId", required = false) String propertyId) {
		List<Property> propertyList = propertyService.findAll();
		theModel.addAttribute("propertyList", propertyList);
		if(propertyId == null && propertyList.size() >0) {
			propertyId = propertyList.get(0).getId()+"";
		}
		Property property = new Property();
		property.setName(propertyId);
		if (!theModel.containsAttribute("searchProperty")) {
	    	theModel.addAttribute("searchProperty",  property);
	    }	
		if(propertyId != null && propertyId.matches("\\d")) {
			property = propertyService.findById(Integer.parseInt(propertyId));
		}
		if (!theModel.containsAttribute("newAnnouncement")) {
			theModel.addAttribute("newAnnouncement", new Announcement());
	    }
		if(display != null) {
			if(display.equals("previous")) {
				theModel.addAttribute("propertyInfo", new DisplayParameter("previous"));
				theModel.addAttribute("announcementList", announcementService.getAnnByLessDate(property.getId()));
			}
			if(display.equals("all")) {
				theModel.addAttribute("propertyInfo", new DisplayParameter("all"));
				theModel.addAttribute("announcementList", announcementService.getAllAnn(property));
			}
			if(display.equals("new")) {
				theModel.addAttribute("propertyInfo", new DisplayParameter("new"));
			}
			if(display.equals("managers")) {
				theModel.addAttribute("propertyInfo", new DisplayParameter("managers"));
				theModel.addAttribute("managersList", userService.getAllManagersOfProperty(property.getId()));
			}
		}else {
			theModel.addAttribute("propertyInfo", new DisplayParameter("current"));
			theModel.addAttribute("announcementList", announcementService.getAnnByCurrentDate(property.getId()));
		}
		return "/manager/property";
	}

	@PostMapping("/chooseProperty")
	public String chooseProperty(@ModelAttribute("searchProperty") Property property, RedirectAttributes attr) {
		attr.addFlashAttribute("searchProperty", property);
		return "redirect:/manager/property?propertyId="+property.getName();
	}
	
	@PostMapping("/saveAnnouncement")
	public String saveAnnouncement(@ModelAttribute("newAnnouncement") @Valid Announcement newAnnouncement, BindingResult bindingResult, RedirectAttributes attr) {
		if(bindingResult.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.newAnnouncement", bindingResult);
			attr.addFlashAttribute("newAnnouncement", newAnnouncement);
			return "redirect:/manager/property?display=new";
		}else {
			announcementService.save(newAnnouncement);
			return "redirect:/manager/property?propertyId="+newAnnouncement.getProperty().getId();
		}	
	}

}





















