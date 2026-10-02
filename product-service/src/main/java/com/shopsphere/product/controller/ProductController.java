package com.shopsphere.product.controller;

import com.shopsphere.product.dto.CreateProductRequest;
import com.shopsphere.product.dto.ProductResponse;
import com.shopsphere.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;
	
	@PostMapping
	public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody CreateProductRequest createProductRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.create(createProductRequest));
	}
	
	@GetMapping
	public ResponseEntity<List<ProductResponse>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(
				productService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
	}
}
