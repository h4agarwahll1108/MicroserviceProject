package com.harshit.customerservice.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.harshit.customerservice.entities.Company;
import com.harshit.customerservice.entities.Customer;
import com.harshit.customerservice.entities.Product;
import com.harshit.customerservice.externalservices.CompanyService;
import com.harshit.customerservice.repositories.CustomerRepository;
import com.harshit.customerservice.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CompanyService companyService;

	@Autowired
	private RestTemplate restTemplate;

	private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Override
	public Customer createCustomer(Customer customer) {
		String randomId = UUID.randomUUID().toString();
		customer.setCustomerId(randomId);
		Customer customer1 = customerRepository.save(customer);
		return customer1;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> listOfCustomer = customerRepository.findAll();
		return listOfCustomer;
	}

	@Override
	public Customer getById(String customerId) {
		Customer customer = customerRepository.findById(customerId).get();

		Product[] productsOfCustomer = restTemplate
				.getForObject("http://PRODUCT-SERVICE/products/customer/" + customer.getCustomerId(), Product[].class);
		// logger.info("{}", productsOfCustomer);

		List<Product> products = Arrays.stream(productsOfCustomer).toList();
		List<Product> collect = products.stream().map(product -> {
			//ResponseEntity<Company> forEntity = restTemplate.getForEntity("http://COMPANY-SERVICE/companys/" + product.getCompanyId(), Company.class);
			//Company company = forEntity.getBody();
			Company company = companyService.getCompanyById(product.getCompanyId());

			product.setCompany(company);
			return product;
		}).collect(Collectors.toList());

		customer.setProducts(collect);

		return customer;
	}

	@Override
	public void deleteCustomer(String customerId) {
		customerRepository.deleteById(customerId);

	}

	@Override
	public void deactivateCustomerById(String customerId) {
		Customer customer = customerRepository.findById(customerId).get();
		if (customer.isActiveFlag()) {
			customer.setActiveFlag(false);
			customerRepository.save(customer);
		}

	}

}
