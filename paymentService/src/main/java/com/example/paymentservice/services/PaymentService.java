package com.example.paymentservice.services;

import com.example.paymentservice.models.Payment;
import com.example.paymentservice.models.PaymentGateWay;
import com.example.paymentservice.models.PaymentStatus;
import com.example.paymentservice.paymentgateways.PaymentGatewayFactory;
import com.example.paymentservice.paymentgateways.PaymentGatewayInterface;
import com.example.paymentservice.repositories.PaymentRepository;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PaymentService {
    private PaymentGatewayFactory paymentGatewayFactory;
    private PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentGatewayFactory paymentGatewayFactory, PaymentRepository paymentRepository) {
        this.paymentGatewayFactory = paymentGatewayFactory;
        this.paymentRepository = paymentRepository;
    }

    public String createPaymentLink(Long orderId){
        //getting the order details from order service using REST template

        //Order order = restTemplate.getForObject("order.url", Order.class);

        String userName = "Sahil Gupta";
        String userPhone = "+919876543210";
        Long amount = 1000L;
        String userEmail = "Sahil@gmail.com";

        PaymentGatewayInterface paymentGateway = paymentGatewayFactory.getBestPaymentGateway();

        String paymentLink = null;
        try {
            paymentLink = paymentGateway.createPaymentLink(amount, userName, userEmail, userPhone, orderId);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }

//        Payment payment = new Payment();
//        payment.setPaymentLink(paymentLink);
//        payment.setPaymentStatus(PaymentStatus.PENDING);
//        payment.setCreatedAt(new Date());
//        payment.setUpdatedAt(new Date());
//        payment.setPaymentGateWay(paymentGateway.getPaymentGatewayType());
//        payment.setOrderId(orderId);
//        payment.setAmount(amount);
//
//        paymentRepository.save(payment);

        System.out.println("create Payment link service");
        return paymentLink;
     }
    public PaymentStatus checkPaymentStatus(String paymentGatewayPaymentId){
        Payment payment = paymentRepository.findByPaymentGatewayReferenceId(paymentGatewayPaymentId);
        PaymentGatewayInterface paymentGateway = null;
        if(PaymentGateWay.RAZORPAY.equals(payment.getPaymentGateWay())){
            paymentGateway = paymentGatewayFactory.getBestPaymentGateway();
        }
        else if(PaymentGateWay.JUSPAY.equals(payment.getPaymentGateWay())){
            paymentGateway = paymentGatewayFactory.getBestPaymentGateway();
        }

        PaymentStatus paymentStatus = paymentGateway.checkPaymentStatus(paymentGatewayPaymentId);
        payment.setPaymentStatus(paymentStatus);

        paymentRepository.save(payment);

        return paymentStatus;
    }
}
