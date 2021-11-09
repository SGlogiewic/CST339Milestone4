package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<RegisterModel>
{
	/* Match the property names in ProcedureModel w/ the column names in the database
	
	Class			Table
	Properties		Column Names
	========================
	id				Id
	firstName		FirstName
	lastName		LastName
	email			Email
	username		Username
	password		Password	
	
	*/
	
	public RegisterModel mapRow(ResultSet resultSet, int i) throws SQLException
	{
		RegisterModel user = new RegisterModel(
				resultSet.getInt("Id"),
				resultSet.getString("FirstName"),
				resultSet.getString("LastName"),
				resultSet.getString("Email"),
				resultSet.getString("Username"),
				resultSet.getString("Password")
				);
		return user;
	}
}
