package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;
import com.example.demo.repo.services.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping(value="/signup")
	public String registerUserGet(User user) {
		return "signup";
	}
	
	@PostMapping(value = "/signup")
	public String registerUserPost(@Valid User user, BindingResult result) {
		System.out.println(user.toString());
		if(result.hasErrors()) 
			return "signup";
		else {
			userServiceImpl.addNewUser(user);
			return "redirect:/authpage";
		}
	}
	
	@GetMapping(value="/authpage")
	public String authoriseUserGet(User user) {
		return "authpage";
	}
	
	@PostMapping(value = "/authpage")
	public String authoriseUserPost(@Valid User user, BindingResult result) {
		
		return "redirect:/isOK";
	}
	
	@GetMapping(value="/isOK")
	public String isOK() {
		return "isOK";
	}

}
