package com.harshit.customerservice.service;

import java.util.List;

import com.harshit.customerservice.entities.Customer;

public interface CustomerService {
	
	Customer createCustomer(Customer customer);
	
	List<Customer> getAllCustomer();
	
	Customer getById(String customerId);
	
	void deleteCustomer(String customerId);
	
	void deactivateCustomerById(String customerId);
	
	
	

}
