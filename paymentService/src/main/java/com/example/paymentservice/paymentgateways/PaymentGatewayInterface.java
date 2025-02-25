package com.example.paymentservice.paymentgateways;

import com.example.paymentservice.models.PaymentGateWay;
import com.example.paymentservice.models.PaymentStatus;
import com.stripe.exception.StripeException;

public interface PaymentGatewayInterface {
    String createPaymentLink(Long amount, String userName, String userEmail, String userPhone, Long orderId) throws StripeException;
    PaymentStatus checkPaymentStatus(String paymentId);
    PaymentGateWay getPaymentGatewayType();
}
