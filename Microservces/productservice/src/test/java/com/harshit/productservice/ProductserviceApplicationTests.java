package com.harshit.productservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.harshit.productservice.entities.Product;
import com.harshit.productservice.services.ProductServices;

@SpringBootTest
class ProductserviceApplicationTests {
	@Autowired
	private ProductServices productServices;

	@Test
	void contextLoads() {
	}
	
	@Test
	void testCreateProduct() {
		Product product = new Product();
		product.setProductName("Milk");
		product.setDescription("Taste of India");
		product.setPrice(27d);
		product.setDiscount(0);
		
		productServices.createProduct(product);
		
	}

}
