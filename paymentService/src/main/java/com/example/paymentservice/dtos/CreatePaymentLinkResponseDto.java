package com.example.paymentservice.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class CreatePaymentLinkResponseDto {
    private String url;
}
