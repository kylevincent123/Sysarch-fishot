package com.zagado.sysarch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zagado.sysarch.model.Order;
import com.zagado.sysarch.repository.OrderRepository;

@RestController
@RequestMapping("Order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/getAllOrders")
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/getOrderById")
    public Order getOrderById(@RequestParam String id) {
        return orderRepository.findById(id).orElse(null); // Handle the Optional
    }

    @PostMapping("/addOrder")
    public String addOrder(@RequestBody Order order) {
        orderRepository.save(order);
        return "Order successfully added.";
    }

    // You can add more endpoints as needed
    // Example: Get orders by description
    @GetMapping("/getOrderByDescription")
    public List<Order> getOrderByDescription(@RequestParam String description) {
        return orderRepository.findAll().stream()
                .filter(order -> order.getDescription().equals(description))
                .toList();
    }
}
