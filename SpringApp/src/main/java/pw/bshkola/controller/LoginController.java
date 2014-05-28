package pw.bshkola.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String login(ModelMap model, @RequestParam(value = "login_error", required = false) String login_error) {
		if (login_error != null) {
			model.addAttribute("message", "Login failed. Please try again:");
		} else {
			model.addAttribute("message", "Please login:");
		}
		return "login";
	}
	
}
