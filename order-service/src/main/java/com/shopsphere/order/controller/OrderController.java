package com.shopsphere.order.controller;

import com.shopsphere.order.dto.CreateOrderRequest;
import com.shopsphere.order.dto.OrderResponse;
import com.shopsphere.order.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;
	
	@PostMapping
	public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody CreateOrderRequest createOrderRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.create(createOrderRequest));
	}
	
	@GetMapping
	public ResponseEntity<List<OrderResponse>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderResponse> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(orderService.findById(id));
	}
}
