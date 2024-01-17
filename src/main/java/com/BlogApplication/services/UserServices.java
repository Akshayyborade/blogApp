package com.BlogApplication.services;

import java.util.List;

import com.BlogApplication.dto.UserDto;

public interface UserServices {
public UserDto saveUser(UserDto userDto);
public UserDto findByEmail(String email);
public List<UserDto> findUsers();
public UserDto findById(int id);
public UserDto updateUser(UserDto updatedUser);
public void deleteUser(int id);
}
