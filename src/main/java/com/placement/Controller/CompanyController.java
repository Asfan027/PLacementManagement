package com.placement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placement.exception.ApiResponse;
import com.placement.payloads.CompanyDto;
import com.placement.service.CompanyService;

@RestController
@RequestMapping("/api")
public class CompanyController 
{

	@Autowired
	private CompanyService companyService;
	
	//To create a company resources
	@PostMapping("/student/{studentId}/company")
	public ResponseEntity<CompanyDto> createCompany(@PathVariable int studentId,@RequestBody CompanyDto companyDto)
	{
		CompanyDto createdCompany = this.companyService.createCompany(companyDto, studentId);
		return new ResponseEntity<CompanyDto>(createdCompany,HttpStatus.CREATED);
	}
	
	//To fetch all the company records as a list
	@GetMapping("/company")
	public ResponseEntity<List<CompanyDto>> getAllCompanies()
	{
		List<CompanyDto> allCompanies = this.companyService.getAllCompanies();
		return new ResponseEntity<List<CompanyDto>>(allCompanies,HttpStatus.OK);
	}
	
	//To fetch a particular company record by company Id
	@GetMapping("/company/{companyId}")
	public ResponseEntity<CompanyDto> getCompanyById(@PathVariable int companyId)
	{
		CompanyDto companyDto = this.companyService.getCompanyById(companyId);
		return new ResponseEntity<CompanyDto>(companyDto,HttpStatus.OK);
	}
	
	//To update a company record by company id
	@PutMapping("/company/{companyId}")
	public ResponseEntity<CompanyDto> updateCompaniesById(@RequestBody CompanyDto companyDto ,@PathVariable int companyId)
	{
		CompanyDto updateCompanies = this.companyService.updateCompaniesById(companyDto, companyId);
		
		return new ResponseEntity<CompanyDto>(updateCompanies,HttpStatus.OK);
		
	}
	
	//To delete company by id
	@DeleteMapping("/company/{companyId}")
	public ResponseEntity<ApiResponse> deleteCompanyById(@PathVariable int companyId)
	{
		this.companyService.deleteCompanyById(companyId);
		ApiResponse response = new ApiResponse();
		response.setMessage("Company Details will be deleted");
		response.setSuccess(true);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
		
	}
	
	// To fetch company record by student id
	@GetMapping("/companies/{studentId}")
	public ResponseEntity<List<CompanyDto>> getAllCompaniesByStudent(@PathVariable int studentId)
	{
		List<CompanyDto> allCompaniesByStudent = this.companyService.getAllCompaniesByStudent(studentId);
		return new ResponseEntity<List<CompanyDto>>(allCompaniesByStudent,HttpStatus.OK);
	}
}
