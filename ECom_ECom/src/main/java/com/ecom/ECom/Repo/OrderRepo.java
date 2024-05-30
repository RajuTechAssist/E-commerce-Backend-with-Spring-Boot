package com.ecom.ECom.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ecom.ECom.Model.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
	
	@Query("SELECT o FROM Order o JOIN FETCH o.orderItems WHERE o.id = :id")
	Optional<Order> findByIdWithOrderItems(@Param("id") Long id);

}
