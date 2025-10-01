package com.example.product;

import jakarta.validation.constraints.*;

public class Product {
    private Long id;
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;
    
    @NotNull
    @Max(value = 500, message = "Price cannot be greater than 500")
    private Double price;
    
    public Product() {}
    
    public Product(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
}