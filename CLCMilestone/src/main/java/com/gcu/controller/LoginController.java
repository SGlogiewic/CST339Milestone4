package com.gcu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ISecurityService;
import com.gcu.model.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController 
{
	@Autowired
	ISecurityService securityService;
	
	@GetMapping("/")
	public String display(Model model)
	{
		// Display Login View
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model)
	{
		// Check for validation errors
		if (bindingResult.hasErrors())
		{
			model.addAttribute("title", "Login Form");
			return "login";
		}
		
		// Check for valid login
		if (securityService.isAuthenticated(loginModel))
		{
			// Login Success. Send them to the succes page to show what they entered
			model.addAttribute("loginModel", loginModel);
			return "loginSuccess";
		}
		else
		{
			// Login Failed
			return "login";
		}
	}
}
