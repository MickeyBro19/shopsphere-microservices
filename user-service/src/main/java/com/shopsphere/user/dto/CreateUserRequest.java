package com.shopsphere.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateUserRequest {
	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;
}
