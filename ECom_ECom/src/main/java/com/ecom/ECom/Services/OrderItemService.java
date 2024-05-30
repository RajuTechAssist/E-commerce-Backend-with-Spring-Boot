package com.ecom.ECom.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.ECom.Model.Order;
import com.ecom.ECom.Model.OrderItem;
import com.ecom.ECom.Repo.OrderItemRepo;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepo orderItemRepo;

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepo.save(orderItem);
    }

    public Optional<Order> getOrderItemById(long id) {
        return orderItemRepo.findById(id);
    }

    public List<Order> getAllOrderItems() {
        return orderItemRepo.findAll();
    }

    public OrderItem updateOrderItem(long id, OrderItem updatedOrderItem) {
        // Find order item, update the details and save
        // Handle error if order item not found
        return orderItemRepo.save(updatedOrderItem);
    }

    public void deleteOrderItem(long id) {
        orderItemRepo.deleteById(id);
    }
}