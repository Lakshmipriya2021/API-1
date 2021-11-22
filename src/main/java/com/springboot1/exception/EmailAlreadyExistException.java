package com.springboot1.exception;

public class EmailAlreadyExistException extends Exception{
	
	public EmailAlreadyExistException(String msg) {
		super(msg);
	}

}
