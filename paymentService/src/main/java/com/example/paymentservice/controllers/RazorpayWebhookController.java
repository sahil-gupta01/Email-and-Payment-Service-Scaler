package com.example.paymentservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhooks/razorpay")
public class RazorpayWebhookController {

    @PostMapping
    public void handleWebhook(){
        System.out.println("webhooks by razorpay");
    }
}
