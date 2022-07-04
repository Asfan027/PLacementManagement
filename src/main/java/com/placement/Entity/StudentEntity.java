package com.placement.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="student")
@Builder
public class StudentEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name = "stud", initialValue = 101, sequenceName = "stud")
//	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "stud")

	private int studentId;
	
	@Column(nullable=false)
	private String studentName;
	
	@Column(nullable=false)
	private String studentEmail;
	
	@Column(nullable=false)
	private String studentContact;

	@Column(nullable=false)
	private String studentQualification;
	
	@Column(nullable=false)
	private String password;
	
	@ManyToOne
	private AdminEntity admin;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<CompanyEntity> companyEntity=new ArrayList<CompanyEntity>();
	


}
