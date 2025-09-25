package com.example.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    private ProductClient productClient;
    
    private Map<Long, Order> orders = new HashMap<>();
    
    public OrderController() {
        orders.put(1L, new Order(1L, 1L, 2));
        orders.put(2L, new Order(2L, 2L, 1));
    }
    
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        Order order = orders.get(id);
        if (order != null) {
            Product product = productClient.getProduct(order.getProductId());
            order.setProduct(product);
        }
        return order;
    }
    
    @GetMapping
    public Collection<Order> getAllOrders() {
        return orders.values();
    }
}