package com.harshit.customerservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.customerservice.entities.Customer;
import com.harshit.customerservice.service.CustomerService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
    private Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@PostMapping("/")
	public ResponseEntity<Customer> creatingCustomer(@RequestBody Customer customer) {
		Customer customer2 = customerService.createCustomer(customer);
		return ResponseEntity.status(HttpStatus.CREATED).body(customer2);

	}

	@GetMapping("/")
	public ResponseEntity<List<Customer>> fetchAllCustomer() {
		List<Customer> listOfCustomer = customerService.getAllCustomer();
		return ResponseEntity.status(HttpStatus.OK).body(listOfCustomer);

	}

	@GetMapping("/{customerId}")
	//@CircuitBreaker(name ="productCompanyBreaker", fallbackMethod = "productCompanyFallBack")
//  @Retry(name = "productCompanyService", fallbackMethod = "productCompanyFallBack")
  @RateLimiter(name = "productCompanyRateLimiter", fallbackMethod = "productCompanyFallBack")

	public ResponseEntity<Customer> getSingleCustomer(@PathVariable String customerId) {
		Customer customer = customerService.getById(customerId);
		return ResponseEntity.status(HttpStatus.OK).body(customer);

	}
//----------------------------	
	
	public ResponseEntity<Customer> productCompanyFallBack(String customerId, Exception ex) {
		logger.info("Fallback is executed because service is down : ", ex.getMessage());
		Customer customer = Customer.builder()
				.email("dummy@gmail.com")
				.activeFlag(false)
				.firstName("Dummy")
				.lastName("Name")
				.customerId("123")
				.build();
        return new ResponseEntity<>(customer, HttpStatus.BAD_REQUEST);

	}
//------------------------------	
	
	@DeleteMapping("/{customerId}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable String customerId) {
		customerService.deleteCustomer(customerId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Sucessfully Deleted " + customerId);

	}

	@PatchMapping("/{customerId}")
	public ResponseEntity<String> deactivateCustomer(@PathVariable String customerId) {
		customerService.deactivateCustomerById(customerId);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Sucessfully Updated " + customerId);
	}

}
