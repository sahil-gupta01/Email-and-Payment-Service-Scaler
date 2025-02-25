package com.foodOrderingApp.app.controllers;

import com.foodOrderingApp.app.dtos.OrderRequestDto;
import com.foodOrderingApp.app.dtos.OrderResponseDto;
import com.foodOrderingApp.app.exceptions.InvalidOrderException;
import com.foodOrderingApp.app.models.Order;
import com.foodOrderingApp.app.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PutMapping(value = "/{id}")
    public ResponseEntity<OrderResponseDto> updateOrder(@PathVariable("id") Long id, @RequestBody OrderRequestDto orderRequestDto) throws InvalidOrderException {
        Order order = orderService.updateOrder(id, orderRequestDto);
        OrderResponseDto orderResponseDto = new OrderResponseDto(order, "successfully update the order");
        return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);
    }

}
