package com.shopsphere.product.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Builder
@Getter
public class ProductResponse {
	private Long id;
	private String name;
	private BigDecimal price;
}
