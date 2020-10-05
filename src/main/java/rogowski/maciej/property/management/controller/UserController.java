package rogowski.maciej.property.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import rogowski.maciej.property.management.Service.UserService;
import rogowski.maciej.property.management.entity.Property;
import rogowski.maciej.property.management.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService theUserService) {
		userService = theUserService;
	}
	
	@GetMapping("/user")
	public String showUser(Authentication authentication, Model theModel){
		User theUser = userService.findById(authentication.getName());
		theModel.addAttribute("user", theUser);			
		theModel.addAttribute("user1", theUser);		
		Property theProperty = theUser.getProperty();
		theModel.addAttribute("property", theProperty);
		
		return "/user/user";
	}

	@PostMapping("/userUpdate")
	public String updateUser(@ModelAttribute("user1") User theUser) {		
		theUser.setPassword(userService.findById(theUser.getLogin()).getPassword());
		theUser.setProperty(userService.findById(theUser.getLogin()).getProperty());
		userService.save(theUser);
		return "redirect:/user/user";
	}
}
