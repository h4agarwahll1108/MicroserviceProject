package com.harshit.companyservice.servceimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.harshit.companyservice.entities.Company;
import com.harshit.companyservice.repositories.CompanyRepository;
import com.harshit.companyservice.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company createCompany(Company company) {
		String randomId = UUID.randomUUID().toString();
		company.setCompanyId(randomId);
		Company company1 = companyRepository.save(company);
		return company1;
	}

	@Override
	public List<Company> getAllCompany() {
		List<Company> listOfCompany = companyRepository.findAll();
		return listOfCompany;
	}

	@Override
	public Company getCompanyById(String companyId) {
		Company company = companyRepository.findById(companyId).get();
		return company;
	}

	@Override
	public void deleteCompanyById(String companyId) {
		companyRepository.deleteById(companyId);

	}

}
