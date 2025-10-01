package com.example.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.order.config.ProductClientConfig;

@FeignClient(name = "product-service", url = "http://localhost:8081" ,configuration = ProductClientConfig.class)
public interface ProductClient {
    
    @GetMapping("/products/{id}")
    Product getProduct(@PathVariable Long id);
    
    @PostMapping("/products")
    Product saveProduct(@RequestBody Product product);
}