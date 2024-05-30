package com.ecom.ECom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ECom.Model.Payment;
import com.ecom.ECom.Services.PaymentService;
import com.ecom.ECom.Services.RazorpayService;
import com.razorpay.Order;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private RazorpayService razorpayService;

    @PostMapping("/create-razorpay-order")
    public ResponseEntity<Order> createRazorpayOrder(@RequestBody Payment payment) {
        try {
            Order razorpayOrder = razorpayService.createRazorpayOrder(payment.getConfirmationCode(), payment.getCurrency(), payment.getAmount(), payment.getMode());
            return ResponseEntity.ok(razorpayOrder);
        } catch (Exception e) {
            // Return an appropriate error response
            return ResponseEntity.status(500).body(null);
        }
    }

    // Additional payment-related endpoints as needed
}
