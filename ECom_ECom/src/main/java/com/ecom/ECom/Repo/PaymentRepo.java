package com.ecom.ECom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.ECom.Model.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long> {

}
