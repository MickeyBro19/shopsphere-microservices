package com.shopsphere.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Builder
@Getter
public class UserResponse {
	private Long id;
	private String name;
	private String email;
}
