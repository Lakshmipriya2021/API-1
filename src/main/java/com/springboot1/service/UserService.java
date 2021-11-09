package com.springboot1.service;

import com.springboot1.model.Api1Response;
import com.springboot1.model.User;

public interface UserService {
	
	public Api1Response getUserById(Long userId);
	
	public Api1Response addUser(User user);
	
	public Api1Response updateUser(User user);
	
	public Api1Response deleteUser(Long userId);

}
