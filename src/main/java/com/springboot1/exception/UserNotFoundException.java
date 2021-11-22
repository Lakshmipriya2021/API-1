package com.springboot1.exception;

public class UserNotFoundException extends Exception {
	
	public UserNotFoundException(String msg) {
		super(msg);
	}

}
