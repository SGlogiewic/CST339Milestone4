package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.IUserBusinessService;
import com.gcu.model.RegisterModel;

@Controller
@RequestMapping("/register")
public class RegisterController 
{
	@Autowired
	IUserBusinessService service;
	
	@GetMapping("/")
	public String display(Model model)
	{
		// Display Register View
		model.addAttribute("title", "Register Form");
		model.addAttribute("registerModel", new RegisterModel());
		return "register";
	}
	
	@PostMapping("/doRegister")
	public String doRegister(@Valid RegisterModel newUser, BindingResult bindingResult, Model model)
	{
		// add the new order
        service.createUser(newUser);
		
		model.addAttribute("registerModel", newUser);
		return "registerSuccess";
	}
}
