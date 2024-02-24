package com.harshit.customerservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit.customerservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
	
	

}
