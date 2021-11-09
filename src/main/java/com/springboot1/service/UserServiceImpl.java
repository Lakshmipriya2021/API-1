package com.springboot1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${get_user_by_id.url}")
	private String GET_USER_BY_ID_URI;
	
	@Value("${post_add_user.url}")
	private String POST_ADD_USER_URI;
	
	@Value("${put_update_user.url}")
	private String PUT_UPDATE_USER_URI;
	
	@Value("${delete_user.url}")
	private String DELETE_USER_URI;

	@Autowired
	WebClient webClient;

	@Override
	public Api1Response getUserById(Long userId) {
		Api2Response api2Response = webClient.get().uri(GET_USER_BY_ID_URI, userId)
				.retrieve().bodyToMono(Api2Response.class).block();
		if (api2Response == null) {
			return null;
		}
		
		if (api2Response.getResponseType().equals(FAILED)) {
			api2Response.getResponseMessage();	
		}
		
		return this.getResponse(api2Response);
	}
	
	@Override
	public Api1Response addUser(User user) {
		Api2Response api2Response = webClient.post().uri(POST_ADD_USER_URI)
				.bodyValue(this.UserToUserRequest(user)).retrieve().bodyToMono(Api2Response.class).block();
		
		if(api2Response == null) {
			return null;
		}
		
		if(api2Response.getResponseType().equals(FAILED)) {
			api2Response.getResponseMessage();
		}
		return this.getResponse(api2Response);
	}
	
	@Override
	public Api1Response updateUser(User user) {
		Api2Response api2Response = webClient.put().uri(PUT_UPDATE_USER_URI)
				.bodyValue(this.UserToUserRequest(user)).retrieve().bodyToMono(Api2Response.class).block();
		
		if(api2Response == null) {
			return null;
		}
		
		if(api2Response.getResponseType().equals(FAILED)) {
			api2Response.getResponseMessage();
		}
		return this.getResponse(api2Response);
	}

	@Override
	public Api1Response deleteUser(Long userId) {
		Api2Response api2Response = webClient.delete().uri(DELETE_USER_URI)
				.retrieve().bodyToMono(Api2Response.class).block();
		if(api2Response == null) {
			return null;
		}
		
		if(api2Response.getResponseType().equals(FAILED)) {
			api2Response.getResponseMessage();
		}
		return this.getResponse(api2Response);
	}

	private Api1Response getResponse(Api2Response api2Response) {
		// TODO Auto-generated method stub
		Api1Response api1Response = new Api1Response();
		User user = this.UserRequestToUser(api2Response.getApi2Rqt());
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
