package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.UserDataServiceForRepository;
import com.gcu.model.RegisterModel;
import com.gcu.model.UserEntity;

@Service
public class UserBusinessService implements IUserBusinessService 
{
	@Autowired
	UserDataServiceForRepository service;

	@Override
	public int createUser(RegisterModel newUser) 
	{
		UserEntity entity = new UserEntity(
				newUser.getId(),
				newUser.getFirstName(),
				newUser.getLastName(),
				newUser.getEmail(),
				newUser.getUsername(),
				newUser.getPassword()
                );
        return service.createUser(entity);
	}

}
