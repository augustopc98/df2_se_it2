package com.example.demo.controllers;

import com.example.demo.models.CustomerOrder;
import com.example.demo.services.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class CustomerOrderController {

    private final CustomerOrderService orderService;

    @Autowired
    public CustomerOrderController(CustomerOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void placeOrder(@RequestBody CustomerOrder order) {
        orderService.placeOrder(order);
    }

    @GetMapping("/{orderId}")
    public CustomerOrder getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PutMapping("/{orderId}")
    public void updateOrder(@PathVariable Long orderId, @RequestBody CustomerOrder order) {
        orderService.updateOrder(order);
    }

    @DeleteMapping("/{orderId}")
    public void cancelOrder(@PathVariable Long orderId) {
        orderService.cancelOrder(orderId);
    }

    @GetMapping("/customer/{email}")
    public List<CustomerOrder> getOrdersByCustomerEmail(@PathVariable String email) {
        return orderService.getOrdersByCustomerEmail(email);
    }

    @PostMapping("/{orderId}/delivery")
    public void sendOrderForDelivery(@PathVariable Long orderId) {
        orderService.sendOrderForDelivery(orderId);
    }

    @PatchMapping("/{orderId}/status")
    public void updateDeliveryStatus(@PathVariable Long orderId, @RequestBody String status) {
        orderService.updateDeliveryStatus(orderId, status);
    }
}
