package com.example.product;

import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    
    private Map<Long, Product> products = new HashMap<>();
    
    public ProductController() {
        products.put(1L, new Product(1L, "Laptop", 999.99));
        products.put(2L, new Product(2L, "Phone", 599.99));
    }
    
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return products.get(id);
    }
    
    @GetMapping
    public Collection<Product> getAllProducts() {
        return products.values();
    }
    
    @PostMapping
    public Product saveProduct(@Valid @RequestBody Product product) {
        Long id = (long) (products.size() + 1);
        product.setId(id);
        products.put(id, product);
        return product;
    }
}