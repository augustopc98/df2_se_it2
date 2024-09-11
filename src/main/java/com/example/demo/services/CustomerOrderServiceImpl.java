package com.example.demo.services;

import com.example.demo.models.CustomerOrder;
import com.example.demo.repositories.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final CustomerOrderRepository orderRepository;

    @Autowired
    public CustomerOrderServiceImpl(CustomerOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void placeOrder(CustomerOrder order) {
        orderRepository.save(order);
    }

    @Override
    public CustomerOrder getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    @Override
    public void updateOrder(CustomerOrder order) {
        orderRepository.save(order);
    }

    @Override
    public void cancelOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }

    @Override
    public List<CustomerOrder> getOrdersByCustomerEmail(String customerEmail) {
        return orderRepository.findByCustomerEmail(customerEmail);
    }

    @Override
    public void sendOrderForDelivery(Long orderId) {
        CustomerOrder order = getOrderById(orderId);
        if (order != null) {
            order.sendForDelivery();
            orderRepository.save(order);
        }
    }

    @Override
    public void updateDeliveryStatus(Long orderId, String status) {
        CustomerOrder order = getOrderById(orderId);
        if (order != null) {
            order.updateDeliveryStatus(status);
            orderRepository.save(order);
        }
    }
}
