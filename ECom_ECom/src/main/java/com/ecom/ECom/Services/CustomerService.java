package com.ecom.ECom.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecom.ECom.Model.Customer;
import com.ecom.ECom.Repo.CustomerRepo;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public Customer createCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    public Optional<Customer> getCustomerById(long id) {
        return customerRepo.findById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer updateCustomer(long id, Customer updatedCustomer) {
        // Find customer, update the details and save
        // Handle error if customer not found
        return customerRepo.save(updatedCustomer);
    }

    public void deleteCustomer(long id) {
        customerRepo.deleteById(id);
    }
}