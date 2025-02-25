package com.foodOrderingApp.app.dtos;

import com.foodOrderingApp.app.models.User;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductResponseDto {
    private User user;
    private String message;
}
