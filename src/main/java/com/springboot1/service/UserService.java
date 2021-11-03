package com.springboot1.service;

import com.springboot1.model.Response;
import com.springboot1.model.User;

public interface UserService {
	
	public Response getUserById(Long userId);
	
	public Response addUser(User user);
	
	public Response updateUser(User user);
	
	public Response deleteUser(Long userId);

}
