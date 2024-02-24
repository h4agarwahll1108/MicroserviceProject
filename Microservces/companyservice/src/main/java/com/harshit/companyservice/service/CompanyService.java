package com.harshit.companyservice.service;

import java.util.List;

import com.harshit.companyservice.entities.Company;

public interface CompanyService {
	
	Company createCompany(Company company);
	
	List<Company> getAllCompany();
	
	Company getCompanyById(String companyId);
	
	void deleteCompanyById(String companyId);
	

}
