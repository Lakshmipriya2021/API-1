package com.springboot1.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.springboot1.validator.UserDob;

public class User {
	

	public User(long userId,
			@NotNull(message = "Name not be empty") @Size(max = 30, min = 1, message = "The name should be maximum 30 characters") String name,
			@NotNull(message = "Enter the date in YYYY-MM-DD format and less than current date")String dob,
			@NotNull(message = "Email Id should be valid") @Email String email,
			@NotNull(message = "Mobile should be numeric and equal to 10 characters") @Size(max = 10, min = 10) String mobile) {
		super();
		this.userId = userId;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
	}

	public User() {
		super();
	}

	long userId;
	@NotNull(message = "Name not be empty")
	@Size(max =30, min=1,  message = "The name should be maximum 30 characters")
	String name;
	@NotNull(message = "Enter the date in DD-MM-YYYY format and less than current date")
	@UserDob
	String dob;
	@NotNull(message = "Email Id should be valid")
	@Email
	String email;
	@NotNull(message = "Mobile should be numeric and equal to 10 characters")
	@Size(max=10, min=10)
	String mobile;
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", dob=" + dob + ", email=" + email + ", mobile=" + mobile
				+ "]";
	}

	
	

}

