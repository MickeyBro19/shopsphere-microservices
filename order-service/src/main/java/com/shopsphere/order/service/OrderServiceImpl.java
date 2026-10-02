package com.shopsphere.order.service;

import com.shopsphere.order.dto.CreateOrderRequest;
import com.shopsphere.order.dto.OrderResponse;
import com.shopsphere.order.entity.Order;
import com.shopsphere.order.entity.OrderStatus;
import com.shopsphere.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
	private final OrderRepository orderRepository;
	
	@Override
	public OrderResponse create(CreateOrderRequest request) {
		Order savedOrder = Order.builder()
				.userId(request.getUserId()).status(OrderStatus.CREATED).totalAmount(request.getTotalAmount()).build();
		return mapToResponse(orderRepository.save(savedOrder));
	}
	
	@Override
	public OrderResponse findById(Long id) {
		return mapToResponse(orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Order not found")));
	}
	
	@Override
	public OrderResponse findByUserId(Long userId) {
		return mapToResponse(orderRepository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("Order not found")));
	}
	
	@Override
	public List<OrderResponse> findAll() {
		return orderRepository.findAll().stream().map(this :: mapToResponse).toList();
	}
	
	private OrderResponse mapToResponse(Order order) {
		return OrderResponse.builder()
				.id(order.getId()).userId(order.getUserId()).status(order.getStatus()).totalAmount(order.getTotalAmount()).build();
	}
}
