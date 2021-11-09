package com.springboot1.model;

public class Api2Response {
	
	String responseType;
	String responseMessage;
	User user;
	Api2Rqt api2Rqt;
	
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
	
	public Api2Rqt getApi2Rqt() {
		return api2Rqt;
	}

	public void setApi2Rqt(Api2Rqt api2Rqt) {
		this.api2Rqt = api2Rqt;
	}
	
	@Override
	public String toString() {
		return "UserResponse [responseType=" + responseType + ", responseMessage=" + responseMessage + ", api2Rqt=" + api2Rqt
				+ "]";
	}

	
	
	

}
