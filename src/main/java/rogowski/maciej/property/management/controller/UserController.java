package rogowski.maciej.property.management.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import rogowski.maciej.property.management.Service.UserService;
import rogowski.maciej.property.management.entity.Property;
import rogowski.maciej.property.management.entity.User;
import rogowski.maciej.property.management.entity.UserPasswordModel;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService theUserService) {
		userService = theUserService;
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
		theModel.addAttribute("user", theUser);			
		Property theProperty = theUser.getProperty();
		theModel.addAttribute("property", theProperty);	

	    if (!theModel.containsAttribute("userPasswordModel")) {
	    	theModel.addAttribute("userPasswordModel", new UserPasswordModel());
	    }
		return "/user/user";
	}

	@PostMapping("/userUpdate")
	public String updateUser(@ModelAttribute("user") User theUser){		
		theUser.setPassword(userService.findById(theUser.getLogin()).getPassword());
		theUser.setProperty(userService.findById(theUser.getLogin()).getProperty());
		userService.save(theUser);
		return "redirect:/user/user";
	}
	
	@PostMapping("/userPassword")
	public String changeUserPassword(@ModelAttribute("userPasswordModel") @Valid  UserPasswordModel theUserPasswordModel, BindingResult bindingResult, @ModelAttribute("user") User theUser, RedirectAttributes attr){ 		
		if(bindingResult.hasErrors()) {
			attr.addFlashAttribute("org.springframework.validation.BindingResult.userPasswordModel", bindingResult);
			attr.addFlashAttribute("userPasswordModel", theUserPasswordModel);
			return "redirect:/user/user?display=userPass";
		}else {
			return "redirect:/user/user";
		}
	}
	
	
	
	
	
	
	
	

	
}
