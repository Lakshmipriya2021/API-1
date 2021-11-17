package com.springboot1.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.springboot1.model.Api1Response;
import com.springboot1.model.Api2Response;
import com.springboot1.model.Api2Rqt;
import com.springboot1.model.User;

@Service
public class UserServiceImpl implements UserService {

	private static final String FAILED = "FAILED";
	private static final String SUCCESS = "SUCCESS";
	
	private String GET_USER_BY_ID_URI= "/{userId}";
	private String POST_ADD_USER_URI = "/add";
	private String PUT_UPDATE_USER_URI = "/update";
	private String DELETE_USER_URI = "/delete/{userId}";

	private final WebClient webClient;
	public UserServiceImpl(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://localhost:9001/api2/user").build();
	}

	@Override
	public Api1Response getUserById(Long userId) {
		Api2Response api2Response = webClient.get().uri(GET_USER_BY_ID_URI, userId)
			.retrieve()
			.bodyToMono(Api2Response.class)
			.block();
	
		return this.getResponse(api2Response);
	}
	
	@Override
	public Api1Response addUser(User user) {
		Api2Response api2Response = webClient.post().uri(POST_ADD_USER_URI)
				.bodyValue(this.UserToUserRequest(user))
				.retrieve()
				.bodyToMono(Api2Response.class)
				.block();
		
		return this.getResponse(api2Response);
	}
	
	@Override
	public Api1Response updateUser(User user) {
		Api2Response api2Response = webClient.put().uri(PUT_UPDATE_USER_URI)
				.bodyValue(this.UserToUserRequest(user))
				.retrieve()
				.bodyToMono(Api2Response.class)
				.block();
		
		return this.getResponse(api2Response);
	}

	@Override
	public Api1Response deleteUser(Long userId) {
		Api2Response api2Response = webClient.delete().uri(DELETE_USER_URI,userId)
				.retrieve()
				.bodyToMono(Api2Response.class)
				.block();
	
		return this.getResponse(api2Response);
	}

	private Api1Response getResponse(Api2Response api2Response) {
		// TODO Auto-generated method stub
		Api1Response api1Response = new Api1Response();
		//User user = this.UserToUserRequest(user);
		User user=api2Response.getUser();
		api1Response.setUser(user);
		api1Response.setStatus(api2Response.getResponseMessage());
		return api1Response;
	}
	

	private User UserRequestToUser(Api2Rqt userRqt) {
		User user = new User();
		user.setUserId(userRqt.getRqtuserId());
		user.setName(userRqt.getRqtname());
		user.setDob(userRqt.getRqtdob());
		user.setEmail(userRqt.getRqtemail());
		user.setMobile(userRqt.getRqtmobile());
		return user;
	}
	 
	private Api2Rqt UserToUserRequest(User user) {
		Api2Rqt api2Rqt = new Api2Rqt();
		api2Rqt.setRqtuserId(user.getUserId());
		api2Rqt.setRqtname(user.getName());
		api2Rqt.setRqtdob(user.getDob());
		api2Rqt.setRqtemail(user.getEmail());
		api2Rqt.setRqtmobile(user.getMobile());
		return api2Rqt;
	}
}
