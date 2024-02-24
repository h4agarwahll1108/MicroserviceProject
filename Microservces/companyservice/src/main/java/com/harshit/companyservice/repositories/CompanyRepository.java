package com.harshit.companyservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harshit.companyservice.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, String> {

}
