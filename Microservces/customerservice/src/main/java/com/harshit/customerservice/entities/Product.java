package com.harshit.customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private String productId;
	private String productName;
	private String description;
	private double price;
	private int discount;
	private String customerId;
	private String companyId;
	 private Company company;
	

}
