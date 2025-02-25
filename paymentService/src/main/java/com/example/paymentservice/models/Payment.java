package com.example.paymentservice.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Payment extends BaseModel{
    private Long userId;
    private Long orderId;
    private Long amount;
    private PaymentStatus paymentStatus;
    private PaymentGateWay paymentGateWay;
    private String paymentGatewayReferenceId;
    private String paymentLink;
}
