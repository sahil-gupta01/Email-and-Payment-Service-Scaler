package com.foodOrderingApp.app.services;


import com.foodOrderingApp.app.dtos.OrderRequestDto;
import com.foodOrderingApp.app.exceptions.InvalidOrderException;
import com.foodOrderingApp.app.models.Order;
import com.foodOrderingApp.app.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    public Order updateOrder(Long id, OrderRequestDto orderRequestDto) throws InvalidOrderException {
        //get the order with the id
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty()) {
            throw new InvalidOrderException();
        }
        //update the details
        // save the details
        return order.get();
    }
}
