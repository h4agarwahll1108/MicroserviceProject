package com.harshit.companyservice.controller;

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

import com.harshit.companyservice.entities.Company;
import com.harshit.companyservice.service.CompanyService;

@RestController
@RequestMapping("/companys")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping("/")
	public ResponseEntity<Company> creatingCompany(@RequestBody Company company) {
		Company company2 = companyService.createCompany(company);
		return ResponseEntity.status(HttpStatus.CREATED).body(company2);
	}

	@GetMapping("/")
	public ResponseEntity<List<Company>> getAllCompany() {
		List<Company> listOfCompany = companyService.getAllCompany();
		return ResponseEntity.status(HttpStatus.OK).body(listOfCompany);
	}

	@GetMapping("/{companyId}")
	public ResponseEntity<Company> getCompanyById(@PathVariable String companyId) {
		Company byId = companyService.getCompanyById(companyId);
		return ResponseEntity.status(HttpStatus.OK).body(byId);
	}

	@DeleteMapping("/{companyId}")
	public ResponseEntity<String> deleteCompanyById(@PathVariable String companyId) {
		companyService.deleteCompanyById(companyId);
		return ResponseEntity.status(HttpStatus.OK).body("Succesfully Deleted " + companyId);
	}

}
