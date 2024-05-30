package com.ecom.ECom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.ECom.Model.Order;
import com.ecom.ECom.Model.OrderItem;

public interface OrderItemRepo extends JpaRepository<Order, Long> {

	OrderItem save(OrderItem orderItem);

}
