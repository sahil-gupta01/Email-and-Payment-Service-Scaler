package com.foodOrderingApp.app.dtos;


import com.foodOrderingApp.app.models.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class OrderResponseDto {
    private Order order;
    private String message;

}
