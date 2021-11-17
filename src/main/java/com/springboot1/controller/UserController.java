package com.springboot1.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot1.model.Api1Response;
import com.springboot1.model.User;
import com.springboot1.service.UserService;

@RestController
@RequestMapping("/api1")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<Api1Response> getUserById(@Valid @PathVariable Long userId) {
		return new ResponseEntity<Api1Response>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Api1Response> addUser(@Valid @RequestBody User user) {
		return new ResponseEntity<Api1Response>(userService.addUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Api1Response> updateUser(@Valid @RequestBody  User user) {
		return new ResponseEntity<Api1Response>(userService.updateUser(user), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<Api1Response> deleteUser(@Valid @PathVariable("userId")  Long userId){
		return new ResponseEntity<Api1Response>(userService.deleteUser(userId), HttpStatus.OK);
	}
}
