package com.example.order;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/orders-svc")
public class OrderController {
    
    @Autowired
    private ProductClient productClient;
    
    private Map<Long, Order> orders = new HashMap<>();
    
    @jakarta.annotation.PostConstruct
    public void init() {
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
    @RateLimiter(name = "orderRateLimiter", fallbackMethod = "rateLimitedfallback")
    public Collection<Order> getAllOrders() {
        return orders.values();
    }
    
    public Collection<Order> rateLimitedfallback(Throwable throwable) {
    	System.out.println("rateLimitedfallback ....");
    	return orders.values();
    }
    
    @PostMapping(consumes = "application/json")
    public Order createOrder(@RequestBody Order order) {
        Long id = (long) (orders.size() + 1);
        order.setId(id);
        orders.put(id, order);
        return order;
    }
    
    @PostMapping(value = "/products", consumes = "application/json")
    public Product createProduct(@RequestBody Product product) {
        return productClient.saveProduct(product);
    }
}