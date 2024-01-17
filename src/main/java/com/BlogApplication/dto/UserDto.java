package com.BlogApplication.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	private int id;
	private String name;
    private String email;
    private String password;
    private String about;
}
