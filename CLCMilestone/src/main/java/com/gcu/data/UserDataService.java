package com.gcu.data;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.gcu.model.RegisterModel;

@Service
public class UserDataService implements IUserDataAccess<RegisterModel>
{
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	public UserDataService(DataSource dataSource)
	{
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int createUser(RegisterModel newUser) 
	{
		return jdbcTemplate.update(
				"INSERT INTO user (FirstName, LastName, Email, Username, Password) VALUES (?, ?, ?, ?, ?)",
				newUser.getFirstName(),
				newUser.getLastName(),
				newUser.getEmail(),
				newUser.getUsername(),
				newUser.getPassword()
				);
	}
}
