package com.BlogApplication.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class UserDto {
	private int id;
	@NotEmpty(message = "Password should not be empty")
	@Size(min=4, message = "Name should has length greater than 4")
	private String name;
	@Email(message = "Invalid email address")
    private String email;
	@NotEmpty(message = "Password should not be empty")
	@Size(min = 8 , message = "password length should be 8 ")
    private String password;
	@NotEmpty(message = "About should not be empty")
    private String about;
}
