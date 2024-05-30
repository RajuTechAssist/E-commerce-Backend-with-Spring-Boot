package com.ecom.ECom.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ECom.Model.Customer;
import com.ecom.ECom.Model.Order;
import com.ecom.ECom.Model.OrderItem;
import com.ecom.ECom.Model.Product;
import com.ecom.ECom.Repo.CustomerRepo;
import com.ecom.ECom.Repo.OrderRepo;
import com.ecom.ECom.Repo.ProductRepo;
import com.ecom.ECom.Services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ProductRepo productRepo;
    
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        // Fetch all orders from the database using the service class
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        // Fetch a specific order by its ID using the service class
        return orderService.getOrderById(id)
            .orElseThrow(() -> new RuntimeException("Order not found with ID: " + id));
    }
    
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        Customer customer = customerRepo.findById(order.getCustomer().getId()).orElseThrow();
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItem item : order.getOrderItems()) {
            Product product = productRepo.findById(item.getProduct().getId()).orElseThrow();
            item.setProduct(product);
            item.setOrder(order);
            orderItems.add(item);
        }
        order.setCustomer(customer);
        order.setOrderItems(orderItems);
        return orderRepo.save(order); // This line returns the saved order
    }


}
