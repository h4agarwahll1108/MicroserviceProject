package com.harshit.customerservice.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.harshit.customerservice.entities.Company;


@Service
@FeignClient(name = "COMPANY-SERVICE")
public interface CompanyService {
	
	@GetMapping("/companys/{companyId}")
	public Company getCompanyById(@PathVariable String companyId);

}
