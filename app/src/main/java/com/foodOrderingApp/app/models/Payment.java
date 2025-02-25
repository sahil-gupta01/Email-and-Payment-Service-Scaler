package com.foodOrderingApp.app.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Payment extends BaseModel {
    private Long orderId;
    private Map<PaymentType, Double> amount;
    private PaymentStatus paymentStatus;

    public Payment(Long orderId, Map<PaymentType, Double> amount) {
        this.orderId = orderId;
        this.amount = amount;
        this.paymentStatus = PaymentStatus.PENDING;
    }



}
