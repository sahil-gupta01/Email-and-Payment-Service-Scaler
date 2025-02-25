package com.example.paymentservice.paymentgateways;

import com.example.paymentservice.models.PaymentGateWay;
import com.example.paymentservice.models.PaymentStatus;
import com.razorpay.Payment;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RazorpayPaymentGateway implements PaymentGatewayInterface {
    private RazorpayClient razorpayClient;


    @Autowired
    public RazorpayPaymentGateway(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    public PaymentGateWay getPaymentGatewayType(){
        return PaymentGateWay.RAZORPAY;
    }
    @Override
    public String createPaymentLink(Long amount, String userName, String userEmail, String userPhone, Long orderId) {
        JSONObject paymentLinkRequest = new JSONObject();
        paymentLinkRequest.put("amount", amount);
        paymentLinkRequest.put("currency", "INR");
        paymentLinkRequest.put("accept_partial", false);
//        paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by", System.currentTimeMillis() / 1000 + 30 * 60);
        paymentLinkRequest.put("reference_id", orderId.toString());
//        paymentLinkRequest.put("description", "Payment for policy no #23456");
        JSONObject customer = new JSONObject();
        customer.put("name", userPhone);
        customer.put("contact", userName);
        customer.put("email", userEmail);
        paymentLinkRequest.put("customer", customer);
        JSONObject notify = new JSONObject();
        notify.put("sms", true);
        notify.put("email", true);
        paymentLinkRequest.put("reminder_enable", true);
//        JSONObject notes = new JSONObject();
//        notes.put("policy_name", "Jeevan Bima");
//        paymentLinkRequest.put("notes", notes);
        paymentLinkRequest.put("callback_url", "https://google.com/");
        paymentLinkRequest.put("callback_method", "get");

        PaymentLink payment = null;

        try {
            payment = razorpayClient.paymentLink.create(paymentLinkRequest);
        } catch (RazorpayException e) {
            System.out.println("Something went wrong!");
        }
        return payment.get("short_url");
    }

    @Override
    public PaymentStatus checkPaymentStatus(String paymentId){
        Payment payment = null;

        try {
            payment = razorpayClient.payments.fetch(paymentId);
        } catch (RazorpayException e) {
            System.out.println(e);
            System.out.println("Something went wrong !!");
        }
        String paymentStatus = payment.get("status");
        if("captured".equals(paymentStatus)){
            return PaymentStatus.SUCCESSFUL;
        }
        else if("failed".equals(paymentStatus)){
            return PaymentStatus.FAILED;
        }
        return null;
    }
}
