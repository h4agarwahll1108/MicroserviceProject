package com.harshit.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harshit.productservice.entities.Product;
import com.harshit.productservice.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductServices productServices;

	@PostMapping("/")
	public ResponseEntity<Product> creatingProduct(@RequestBody Product product) {
		Product product2 = productServices.createProduct(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(product2);
	}

	@GetMapping("/")
	public ResponseEntity<List<Product>> getAllProduct() {
		List<Product> listOfProduct = productServices.getAllProduct();
		return ResponseEntity.status(HttpStatus.OK).body(listOfProduct);
	}

	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductByd(@PathVariable String productId) {
		Product byId = productServices.getProductById(productId);
		return ResponseEntity.status(HttpStatus.OK).body(byId);
	}

	@DeleteMapping("/{productId}")
	public ResponseEntity<String> deleteProductByd(@PathVariable String productId) {
		productServices.deleteProductById(productId);
		return ResponseEntity.status(HttpStatus.OK).body("Successfully Deleted " + productId);
	}

	@GetMapping("/customer/{customerId}")
	public ResponseEntity<List<Product>> getProductByCustomerId(@PathVariable String customerId) {
		List<Product> byCustomerId = productServices.getProductByCustomerId(customerId);
		return ResponseEntity.status(HttpStatus.OK).body(byCustomerId);
	}

	@GetMapping("/company/{companyId}")
	public ResponseEntity<List<Product>> getProductByCompanyId(@PathVariable String companyId) {
		List<Product> byCompanyId = productServices.getProductByCompanyId(companyId);
		return ResponseEntity.status(HttpStatus.OK).body(byCompanyId);
	}

}
