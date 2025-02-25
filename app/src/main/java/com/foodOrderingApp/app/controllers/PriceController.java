package com.foodOrderingApp.app.controllers;


import com.foodOrderingApp.app.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceController{

    @Autowired
    private PriceService priceService;



}
