package rogowski.maciej.property.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

	@GetMapping("/index")
	public String showIndex() {
		return "/index";
	}
}
