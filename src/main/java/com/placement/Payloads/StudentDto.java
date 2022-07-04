package com.placement.payloads;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDto
{
	private int studentId;
	
	private String studentName;
	
	private String studentEmail;
	
	private String studentContact;
	
	private String studentQualification;
	
	private String password;
	
	private AdminDto admin;
	
	private List<CompanyDto> companyEntity;
	
	
}
