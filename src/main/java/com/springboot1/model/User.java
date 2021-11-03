package com.springboot1.model;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	
	@NotNull(message = "UserId not empty")
	@Size(max =10, min=1,  message = "The id should be in range of 1 to 10 characters")
	long userId;
	@NotNull(message = "Name not be empty")
	@Size(max =30, min=1,  message = "The name should be maximum 30 characters")
	String name;
	@NotNull(message = "Enter the date in YYYY-MM-DD format and less than current date")
	@Past
	@DateTimeFormat(fallbackPatterns = {"DD.MM.YYYY"})
	Date dob;
	@NotNull(message = "Email Id should be valid")
	@Email
	String email;
	@NotNull(message = "Mobile should be numeric and equal to 10 characters")
	@Size(max=10)
	@Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Mobile number is invalid")
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
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
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
