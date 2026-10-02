package com.shopsphere.order.service;

import com.shopsphere.order.dto.CreateOrderRequest;
import com.shopsphere.order.dto.OrderResponse;

import java.util.List;

public interface OrderService {
	
	OrderResponse create(CreateOrderRequest request);
	
	OrderResponse findById(Long id);
	OrderResponse findByUserId(Long userId);
	
	List<OrderResponse> findAll();
}