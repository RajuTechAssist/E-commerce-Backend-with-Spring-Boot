package com.ecom.ECom.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.ECom.Model.Customer;
import com.ecom.ECom.Repo.CustomerRepo;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

	@Autowired
	private CustomerRepo customerRepo;

	@PostMapping
	public Customer registerCustomer(@RequestBody Customer customer) {
		return customerRepo.save(customer);
	}
	
//	@GetMapping
//	public List<Customer> getAllCustomers() {
//	    // Retrieve and return all customers from the repository
//	    return customerRepo.findAll();
//	}

	
	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return customerRepo.findById(id).orElseThrow();
	}

	@PutMapping("/{id}")
	public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
	    Customer existingCustomer = customerRepo.findById(id).orElseThrow();
	    existingCustomer.setName(customer.getName());
	    existingCustomer.setAddress(customer.getAddress());
	    existingCustomer.setEmail(customer.getEmail());
	    return customerRepo.save(existingCustomer);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
	    try {
	        customerRepo.deleteById(id);
	        return ResponseEntity.noContent().build(); // HTTP 204 No Content
	    } catch (DataIntegrityViolationException e) {
	        // Handle the foreign key constraint violation error
	        return ResponseEntity.status(HttpStatus.CONFLICT)
	            .body("Customer cannot be deleted because it is referenced by orders.");
	    }
	}




}
