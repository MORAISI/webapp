package com.freshvotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.freshvotes.domain.Users;
import com.freshvotes.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService ;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	
	@GetMapping("/registeration")
	public String registration(ModelMap model) {
		model.put("user", new Users());
		return "registeration";
	}

	@PostMapping("/registeration")
	public String register(@ModelAttribute Users users) { //modelattribue takes values from html page mapping it here
		userService.saveUsers(users);
		return "redirect:/login";
		
		
	}
}
