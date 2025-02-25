package com.example.paymentservice.paymentgateways;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewayFactory {
    private RazorpayPaymentGateway razorpayPaymentGateway;
    private StripePaymentGateway stripePaymentGateway;

    public PaymentGatewayFactory(RazorpayPaymentGateway razorpayPaymentGateway, StripePaymentGateway stripePaymentGateway){
        this.razorpayPaymentGateway = razorpayPaymentGateway;
        this.stripePaymentGateway = stripePaymentGateway;
    }

    public PaymentGatewayInterface getBestPaymentGateway(){
        //some logic to get the best gateway

//        return razorpayPaymentGateway;
        return stripePaymentGateway;
    }
}
