package com.gcu.business;

import com.gcu.model.LoginModel;
import com.gcu.model.RegisterModel;
import com.gcu.model.UserEntity;

import javax.validation.Valid;

public class Validation implements ISecurityService 
{

	@Override
	public boolean isAuthenticated(LoginModel loginModel) 
	{
		// Create a list of valid login names and passwords
		String[][] validLogins = new String[][] {
			//{"jeannamaye", "password"},
			//{"username", "password2021"}
			{loginModel.getUsername(), loginModel.getPassword()}
		};
		
		// Check to see if the login matches any username/password combo
		boolean success = false;
		for (int i = 0; i < validLogins.length; i++)
		{
			if (loginModel.getUsername().equals(validLogins[i][0]) && loginModel.getPassword().equals(validLogins[i][1]))
			{
				success = true;
			}
		}
		
		if (success)
		{
			// Login Success
			return true;
		}
		else
		{
			return false;
		}
	}
}
