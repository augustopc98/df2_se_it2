package com.example.demo.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerEmail;
    private String customerAddress;
    private Date orderDate;
    private String deliveryStatus;

    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderItem> items;

    // Constructors, Getters, Setters

    public CustomerOrder() {
    }

    public CustomerOrder(String customerEmail, String customerAddress, Date orderDate, List<OrderItem> items) {
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.orderDate = orderDate;
        this.items = items;
    }

    // Specific methods for business logic
    public void addOrderItem(OrderItem item) {
        this.items.add(item);
    }

    public void removeOrderItem(OrderItem item) {
        this.items.remove(item);
    }

    public BigDecimal calculateTotal() {
        return items.stream()
                .map(OrderItem::getProductPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void sendForDelivery() {
        this.deliveryStatus = "In Delivery";
    }

    public void updateDeliveryStatus(String status) {
        this.deliveryStatus = status;
    }

    // Getter and Setter methods
    // ...
}
