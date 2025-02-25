package com.example.paymentservice.controllers;

import com.example.paymentservice.dtos.CreatePaymentLinkRequestDto;
import com.example.paymentservice.dtos.CreatePaymentLinkResponseDto;
import com.example.paymentservice.models.PaymentStatus;
import com.example.paymentservice.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments/")
public class PaymentController {

    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping()
    public CreatePaymentLinkResponseDto createPaymentLink(@RequestBody CreatePaymentLinkRequestDto request){
        String url = paymentService.createPaymentLink(request.getOrderId());
        CreatePaymentLinkResponseDto response = new CreatePaymentLinkResponseDto();
        response.setUrl(url);
        return response;
    }
    @GetMapping("/{id}")
    public PaymentStatus checkPaymentStatus(@PathVariable("id") String paymentGatewayPaymentId){
        return paymentService.checkPaymentStatus(paymentGatewayPaymentId);
    }
    public void handleWebhook(){

    }
}
