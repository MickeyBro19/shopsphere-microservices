package com.shopsphere.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CreateProductRequest {
	@NotBlank
	private String name;
	
	@NotNull
	@Positive
	private BigDecimal price;
}
