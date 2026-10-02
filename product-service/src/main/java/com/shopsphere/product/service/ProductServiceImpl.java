package com.shopsphere.product.service;

import com.shopsphere.product.dto.CreateProductRequest;
import com.shopsphere.product.dto.ProductResponse;
import com.shopsphere.product.entity.Product;
import com.shopsphere.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;
	
	@Override
	public ProductResponse create(CreateProductRequest request) {
		if (productRepository.existsByName(request.getName())) {
			throw new IllegalArgumentException("name already exists");
			
		}
		Product savedproduct = Product.builder()
				.name(request.getName()).price(request.getPrice()).build();
		return mapToResponse(productRepository.save(savedproduct));
	}
	
	@Override
	public ProductResponse findById(Long id) {
		return mapToResponse(productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("product not found")));
	}
	
	@Override
	public List<ProductResponse> findAll() {
		return productRepository.findAll().stream().map(this :: mapToResponse).toList();
	}
	
	private ProductResponse mapToResponse(Product product) {
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.price(product.getPrice())
				.build();
	}
}
