package com.harshit.customerservice.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.harshit.customerservice.entities.Product;

@Service
@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductService {

	@PostMapping("/products")
	public ResponseEntity<Product> createProduct(Product values);

	// PUT
	@PutMapping("/products/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable("productId") String productId, Product product);

	@DeleteMapping("/products/{productId}")
	public void deleteProduct(@PathVariable String productId);

}
