package com.shopsphere.order.dto;

import com.shopsphere.order.entity.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Builder
public class OrderResponse {
	
	private Long id;
	private Long userId;
	private OrderStatus status;
	private BigDecimal totalAmount;
}