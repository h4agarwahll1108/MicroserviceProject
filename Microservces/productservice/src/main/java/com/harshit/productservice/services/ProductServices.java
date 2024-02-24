package com.harshit.productservice.services;

import java.util.List;

import com.harshit.productservice.entities.Product;

public interface ProductServices {
	
	Product createProduct(Product product);
	
		List<Product> getAllProduct();
		
		Product getProductById(String productId);
		
		void deleteProductById(String productId);
		
		List<Product> getProductByCustomerId(String customerId);
		
		List<Product> getProductByCompanyId(String companyId);
		
		
	

}
