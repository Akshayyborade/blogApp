package com.BlogApplication.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BlogApplication.dto.UserDto;
import com.BlogApplication.exceptions.ResourceNotFoundException;
import com.BlogApplication.model.User;
import com.BlogApplication.repository.UserRepo;

@Service
public class UserServiceImpl implements UserServices {
	@Autowired
	UserRepo userRepo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserDto findByEmail(String email) {
		// TODO Auto-generated method stub
		UserDto userDto = new UserDto();
		List<User> users = userRepo.findByEmail(email);
		User user = users.get(0);
		userDto.setName(user.getName());
		userDto.setPassword(user.getPassword());
		userDto.setEmail(user.getEmail());
		userDto.setAbout(user.getAbout());
		return userDto;
	}

	@Override
	public List<UserDto> findUsers() {
		// TODO Auto-generated method stub
		UserDto userDto = new UserDto();
		List<UserDto> userDtos = new ArrayList<>();
		List<User> users = userRepo.findAll();
		for (User user : users) {
			userDto.setName(user.getName());
			userDto.setPassword(user.getPassword());
			userDto.setEmail(user.getEmail());
			userDto.setAbout(user.getAbout());
			userDtos.add(userDto);
		}

		return userDtos;
	}

	@Override
	public UserDto findById(int id) {
		// TODO Auto-generated method stub
		User byId = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
		UserDto userDto = this.userToUserDto(byId);
		return userDto;
	}

	@Override
	public UserDto saveUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User save = userRepo.save(this.userdtoToUser(userDto));
		userDto = this.userToUserDto(save);
		return userDto;
	}
  // manually converted userdto to  user
//	public User userdtoToUser(UserDto userDto) {
//		User user = new User();
//		user.setName(userDto.getName());
//		user.setPassword(userDto.getPassword());
//		user.setEmail(userDto.getEmail());
//		user.setAbout(userDto.getAbout());
//		return user;
//	}
    // manually coverted user to userdto
//	public UserDto userToUserDto(User user) {
//		UserDto userDto = new UserDto();
//		userDto.setName(user.getName());
//		userDto.setPassword(user.getPassword());
//		userDto.setEmail(user.getEmail());
//		userDto.setAbout(user.getAbout());
//		return userDto;
//
//	}
	//using Model mapping 
	public User userdtoToUser(UserDto userDto) {
		User user = modelMapper.map(userDto, User.class);
		return user;
	}
	//using Model mapping
	public UserDto userToUserDto(User user) {
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;

	}
	public UserDto updateUser(UserDto updatedUser) {
		User user = this.userdtoToUser(updatedUser);
		User save = userRepo.save(user);
		return this.userToUserDto(save);
	}
	public void deleteUser(int id) {
		
		try {
			userRepo.deleteById(id);
		} catch (ResourceNotFoundException e) {
			e= new ResourceNotFoundException("user", "id", id);
			// TODO: handle exception
		}
	}

}
