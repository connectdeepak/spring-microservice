package com.example.order;

public class Order {
    private Long id;
    private Long productId;
    private Integer quantity;
    private Product product;
    
    public Order() {}
    
    public Order(Long id, Long productId, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}