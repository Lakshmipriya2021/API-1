package com.springboot1.model;

public class UserResponse {
	
	String responseType;
	String responseMessage;
	User user;
	
	public String getResponseType() {
		return responseType;
	}
	
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}
	
	public String getResponseMessage() {
		return responseMessage;
	}
	
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "UserResponse [responseType=" + responseType + ", responseMessage=" + responseMessage + ", user=" + user
				+ "]";
	}
	
	

}
