package com.example.demo.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private int quantity;
    private BigDecimal productPrice;

    // Constructors, Getters, Setters

    public OrderItem() {
    }

    public OrderItem(Long productId, int quantity, BigDecimal productPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.productPrice = productPrice;
    }

    // Renamed method
    public BigDecimal getProductPrice() {  // Changed from getPrice to getProductPrice
        return productPrice;
    }

    // Other Getters and Setters
}

