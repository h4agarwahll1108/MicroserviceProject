package com.harshit.customerservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.harshit.customerservice.entities.Customer;
import com.harshit.customerservice.service.CustomerService;

//@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerserviceApplicationTests {
	@Autowired
	private CustomerService customerservice;

	@Test
	void contextLoads() {
	}
	@Test
	void testCreateCustomer() {
		
		Customer customer = new Customer();
		customer.setFirstName("Harshit");
		customer.setLastName("Agarwal");
		customer.setEmail("harsht@gmal.com");
		customer.setPhoneNumber(7248196422L);
		customer.setActiveFlag(true);
		
		customerservice.createCustomer(customer);
		
		
	}

}
