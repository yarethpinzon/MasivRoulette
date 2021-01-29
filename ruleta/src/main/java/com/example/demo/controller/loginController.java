package com.example.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.model.credentials;
@Controller
public class loginController {
	@GetMapping("/")
	public String redirectLogin() {
		return "redirect:/login";
	}
	@GetMapping("/login")
	public String Login(Model model,
			@RequestParam(name="error")String ERROR) {
		model.addAttribute("error",ERROR);
		model.addAttribute("credentials",new credentials());
		
		return "login";
	}
	@PostMapping("/login")
	public String check(@ModelAttribute(name="credentials") credentials credentials) {
		if(credentials.getName().equals("comodin") && credentials.getPassword().equals("comdin")) {
			return "users";
		}else {
			return "redirect:/login";
		}
		
	}
}
