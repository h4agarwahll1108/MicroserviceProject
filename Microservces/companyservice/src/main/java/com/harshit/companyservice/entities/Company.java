package com.harshit.companyservice.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company")
public class Company {
	@Id
	@Column(name = "company_id")
	private String companyId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "locaton")
	private String location;
	
	@Column(name = "about", length = 500)
	private String about;
	
	@Column(name = "foundation_year")
	private String foundationYear;
	

}
