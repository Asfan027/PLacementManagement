package com.placement.repo;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.placement.entity.CompanyEntity;
import com.placement.entity.StudentEntity;
import com.placement.repository.CompanyRepository;
import com.placement.repository.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CompanyrepositoryTest 
{
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	@Order(1)
	public void saveCompanytest()
	{
		CompanyEntity company=CompanyEntity.builder()
				              .companyName("TCS")
				              .companyType("IT")
							  .companyAddress("Hyderabad")
							  .companyDescription("Good Knowledge in IT skills").build();

		companyRepository.save(company);
		Assertions.assertThat(company.getCompanyId()).isGreaterThan(0);
		
	}
	@Test
	@Order(1)
	public void getCompanyById()
	{
		CompanyEntity company=companyRepository.findById(101).get();
		Assertions.assertThat(company.getCompanyId()).isGreaterThan(0);
	}
	@Test
	@Order(2)
	public void getCompanyList()
	{
		List<CompanyEntity> company=this.companyRepository.findAll();
		Assertions.assertThat(company.size()).isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void updateCompany()
	{
		CompanyEntity company=companyRepository.findById(102).get();
		company.setCompanyAddress("Bangalore");
	    CompanyEntity company1=companyRepository.save(company);
		Assertions.assertThat(company1.getCompanyAddress()).isEqualTo("Bangalore");
	}
	@Test
	@Order(5)
	public void deleteCompany()
	{
		 CompanyEntity company = companyRepository.findById(102).get();
		 companyRepository.delete(company);
		  CompanyEntity company1=null;
		  Optional<CompanyEntity> optionalCompany=companyRepository.findBycompanyType("IT");
		  if(optionalCompany.isPresent())
		  {
			  company1=optionalCompany.get();
			  
		  }
		  Assertions.assertThat(company1).isNull();
	}
	@Test
	@Order(6)
	public void getCompanyByStudent()
	{
		StudentEntity student=studentRepository.findById(101).get();
		List<CompanyEntity> companyList=companyRepository.findByStudent(student);
		Assertions.assertThat(companyList.size()).isGreaterThan(0);
		
	}

}
