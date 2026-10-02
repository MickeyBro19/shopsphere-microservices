package com.shopsphere.user.service;

import com.shopsphere.user.dto.CreateUserRequest;
import com.shopsphere.user.dto.UserResponse;

import java.util.List;

public interface UserService {
	
	UserResponse create(CreateUserRequest request);
	
	UserResponse findById(Long id);
	
	List<UserResponse> findAll();
}