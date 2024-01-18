package com.BlogApplication.controller;

import java.util.List;

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

import com.BlogApplication.dto.UserDto;
import com.BlogApplication.payload.ApiResponse;
import com.BlogApplication.services.UserServices;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	UserServices userServices;

	@PostMapping("/register")
	public ResponseEntity<UserDto> creatUser(@RequestBody UserDto userDto) {
		UserDto saveUser = this.userServices.saveUser(userDto);
		return new ResponseEntity<>(saveUser, HttpStatus.CREATED);
	}

	@GetMapping("/getUser/{userId}")
	public ResponseEntity<UserDto> getUser(@PathVariable int userId) {
		UserDto byId = userServices.findById(userId);
		return new ResponseEntity<>(byId, HttpStatus.FOUND);
	}

	@GetMapping("/getUsers")
	public ResponseEntity<List<UserDto>> getUsers() {
		List<UserDto> users = userServices.findUsers();
		return new ResponseEntity<>(users, HttpStatus.FOUND);
	}

	@PutMapping("/updateUser")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
		UserDto updateUser = userServices.updateUser(userDto);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable int id) {
		userServices.deleteUser(id);
		return new ResponseEntity<>(new ApiResponse("User Deleted", true), HttpStatus.OK);
	}
}
