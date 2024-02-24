package com.harshit.customerservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {
	
	private String companyId;
	private String companyName;
	private String location;
	private String about;
	private String foundationYear;


}
