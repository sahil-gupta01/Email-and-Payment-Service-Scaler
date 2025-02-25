package com.foodOrderingApp.app.controllers;

import com.foodOrderingApp.app.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    // make all the required methods as per the requirement
}
