package com.example.paymentservice.paymentgateways;

import com.example.paymentservice.models.PaymentGateWay;
import com.example.paymentservice.models.PaymentStatus;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.model.Product;
import com.stripe.param.PaymentIntentCreateParams;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import com.stripe.param.ProductCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentGateway implements PaymentGatewayInterface{

    @Value("${stripe.api_key}")
    private String apiKey;

    public PaymentGateWay getPaymentGatewayType(){
        return PaymentGateWay.STRIPE;
    }
    @Override
    public String createPaymentLink(Long amount, String userName, String userEmail, String userPhone, Long orderId) throws StripeException {
        Stripe.apiKey = apiKey;


        ProductCreateParams params =
                ProductCreateParams.builder().setName("Generic").build();
        Product product = Product.create(params);

        PriceCreateParams priceCreateParams =
                PriceCreateParams.builder()
                        .setCurrency("inr")
                        .setUnitAmount(amount)
                        .setProduct(product.getId())
                        .build();

        Price price = Price.create(priceCreateParams);

        PaymentLinkCreateParams paymentLinkCreateParams =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice(price.getId())
                                        .setQuantity(1L)
                                        .build()
                        )
                        .build();

        PaymentLink paymentLink = PaymentLink.create(paymentLinkCreateParams);
        return paymentLink.getUrl();
    }

    @Override
    public PaymentStatus checkPaymentStatus(String paymentId) {
        return null;
    }
}
