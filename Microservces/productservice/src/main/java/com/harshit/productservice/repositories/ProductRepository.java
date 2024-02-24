package com.harshit.productservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit.productservice.entities.Product;

public interface ProductRepository extends JpaRepository<Product, String>{
	
	List<Product> findByCustomerId(String customerId);
	List<Product> findByCompanyId(String companyId);

}
