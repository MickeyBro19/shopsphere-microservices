package com.shopsphere.product.service;

import com.shopsphere.product.dto.CreateProductRequest;
import com.shopsphere.product.dto.ProductResponse;

import java.util.List;

public interface ProductService {
	
	ProductResponse create(CreateProductRequest request);
	
	ProductResponse findById(Long id);
	
	List<ProductResponse> findAll();
}