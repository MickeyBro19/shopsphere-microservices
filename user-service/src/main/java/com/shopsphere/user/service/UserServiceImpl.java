package com.shopsphere.user.service;

import com.shopsphere.user.dto.CreateUserRequest;
import com.shopsphere.user.dto.UserResponse;
import com.shopsphere.user.entity.User;
import com.shopsphere.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	
	@Override
	public UserResponse create(CreateUserRequest request) {
		if (userRepository.existsByEmail(request.getEmail())) {
			throw new IllegalArgumentException("Email already exists");
			
		}
		User savedUser= User.builder()
				.name(request.getName()).email(request.getEmail()).build();
		return mapToResponse(userRepository.save(savedUser));
	}
	
	@Override
	public UserResponse findById(Long id) {
		return mapToResponse(userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("User not found")));
	}
	
	@Override
	public List<UserResponse> findAll() {
		return userRepository.findAll().stream().map(this::mapToResponse).toList();
	}
	
	private UserResponse mapToResponse(User user) {
		return UserResponse.builder()
				.id(user.getId())
				.name(user.getName())
				.email(user.getEmail())
				.build();
	}
}
