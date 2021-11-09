package com.gcu.business;

import com.gcu.model.LoginModel;
import com.gcu.model.RegisterModel;
import com.gcu.model.UserEntity;

public interface ISecurityService 
{
	public boolean isAuthenticated(LoginModel loginModel);
}
