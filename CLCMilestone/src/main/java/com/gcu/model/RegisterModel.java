package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterModel 
{
	private int id; 
	
	@NotNull(message="First Name is a required field")
	@Size(min=5, message="First Name must be at least 5 characters")
	private String firstName;
	
	@NotNull(message="Last Name is a required field")
	@Size(min=5, message="Last Name must be at least 5 characters")
	private String lastName;
	
	@NotNull(message="Username is a required field")
	@Size(min=5, max=32, message="Username must be between 5 and 32 characters")
	private String username;
	
	@NotNull(message="Email is a required field")
	@Size(min=5, message="Email must be at least 5 characters")
	private String email;
	
	@NotNull(message="Password is a required field")
	@Size(min=5, max=32, message="Username must be between 5 and 32 characters")
	private String password;

	public RegisterModel(int id, String firstName, String lastName, String username, String email, String password)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public RegisterModel() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	@Override
	public String toString()
	{
		return "RegisterModel [First Name=" + firstName + ", Last Name=" + lastName + ", Username=" + username + ", Email=" + email + ", Password=" + password + "]";
	}
}
