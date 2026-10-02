package com.shopsphere.order.repository;

import com.shopsphere.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
	boolean existsByUserId(Long userId);
	
	Optional<Order> findByUserId(Long userId);
}
