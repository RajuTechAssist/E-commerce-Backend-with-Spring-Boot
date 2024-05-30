package com.ecom.ECom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.ECom.Model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

}
