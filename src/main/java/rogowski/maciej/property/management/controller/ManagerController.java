package rogowski.maciej.property.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manager")
public class ManagerController {

	@GetMapping("/manager")
	public String showUser(){
		return "/manager/manager.html";
	}
	
}
