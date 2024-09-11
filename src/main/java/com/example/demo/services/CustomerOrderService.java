package com.example.demo.services;

import com.example.demo.models.CustomerOrder;
import java.util.List;

public interface CustomerOrderService {
    void placeOrder(CustomerOrder order);
    CustomerOrder getOrderById(Long orderId);
    void updateOrder(CustomerOrder order);
    void cancelOrder(Long orderId);
    List<CustomerOrder> getOrdersByCustomerEmail(String customerEmail);
    void sendOrderForDelivery(Long orderId);
    void updateDeliveryStatus(Long orderId, String status);
}
