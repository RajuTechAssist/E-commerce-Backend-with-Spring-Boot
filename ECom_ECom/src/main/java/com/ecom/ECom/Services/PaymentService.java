package com.ecom.ECom.Services;

import com.ecom.ECom.Model.Payment;
import com.ecom.ECom.Repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public Payment createPayment(Payment payment) {
        return paymentRepo.save(payment);
    }

    public Optional<Payment> getPaymentById(Long id) {
        return paymentRepo.findById(id);
    }

    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }

    public Payment updatePayment(Long id, Payment updatedPayment) {
        // Update payment details and save
        Payment existingPayment = paymentRepo.findById(id).orElseThrow();
        existingPayment.setMode(updatedPayment.getMode());
        existingPayment.setAmount(updatedPayment.getAmount());
        existingPayment.setConfirmationCode(updatedPayment.getConfirmationCode());
        return paymentRepo.save(existingPayment);
    }

    public void deletePayment(Long id) {
        paymentRepo.deleteById(id);
    }
}
