package com.example.paymentservice.repositories;

import com.example.paymentservice.models.Payment;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Payment findByPaymentGatewayReferenceId(String paymentReferenceId);

    @NotNull
    Payment save(@NotNull Payment payment);
}
