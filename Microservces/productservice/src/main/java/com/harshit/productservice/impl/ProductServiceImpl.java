package com.harshit.productservice.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshit.productservice.entities.Product;
import com.harshit.productservice.repositories.ProductRepository;
import com.harshit.productservice.services.ProductServices;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductServices {

	@Autowired
	private ProductRepository productRepository;

	@Override
	@Transactional
	public Product createProduct(Product product) {

		String randomId = UUID.randomUUID().toString();
		product.setProductId(randomId);
		Product product1 = productRepository.save(product);
		return product1;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> listOfProduct = productRepository.findAll();
		return listOfProduct;
	}

	@Override
	public Product getProductById(String id) {
		Product product = productRepository.findById(id).get();
		return product;
	}

	@Override
	public void deleteProductById(String Id) {
		productRepository.deleteById(Id);

	}

	@Override
	public List<Product> getProductByCustomerId(String customerId) {
		List<Product> byCustomerId = productRepository.findByCustomerId(customerId);
		return byCustomerId;
	}

	@Override
	public List<Product> getProductByCompanyId(String companyId) {
		List<Product> byCompanyId = productRepository.findByCompanyId(companyId);
		return byCompanyId;
	}

}
