package com.foodOrderingApp.app.controllers;

import com.foodOrderingApp.app.dtos.ProductResponseDto;
import com.foodOrderingApp.app.exceptions.InvalidUserException;
import com.foodOrderingApp.app.models.User;
import com.foodOrderingApp.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getUser(@PathVariable("id") Long userId) throws InvalidUserException {
        User user = userService.getUser(userId);
        ProductResponseDto productResponseDto = new ProductResponseDto(user, "successful");
        return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> addUser(@RequestBody User user){
        User savedUser = userService.addUser(user);

        ProductResponseDto productResponseDto = new ProductResponseDto(savedUser, "successful");
        return new ResponseEntity<>(productResponseDto, HttpStatus.OK);
    }

//    @DeleteMapping to delete user

//    @PostMapping to update user

}
