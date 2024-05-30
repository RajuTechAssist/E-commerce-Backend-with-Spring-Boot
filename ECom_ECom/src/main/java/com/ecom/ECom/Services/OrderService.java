package com.ecom.ECom.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.ecom.ECom.Model.Order;
import com.ecom.ECom.Repo.OrderRepo;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Order createOrder(@RequestBody Order order) {
        return orderRepo.save(order);
    }

    public Optional<Order> getOrderById(long id) {
        return orderRepo.findByIdWithOrderItems(id);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order updateOrder(long id, Order updatedOrder) {
        // Find order, update the details and save
        // Handle error if order not found
        return orderRepo.save(updatedOrder);
    }

    public void deleteOrder(long id) {
        orderRepo.deleteById(id);
    }
}
