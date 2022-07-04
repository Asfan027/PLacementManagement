package com.placement.payloads;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.placement.entity.StudentEntity;

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
public class CompanyDto
{
	private int companyId;
	private String companyName;
	private String companyAddress;
	private String companyType;
	private String companyDescription;

	private StudentDto student;
	private List<TrainingDto> trainingDtoList;
}
