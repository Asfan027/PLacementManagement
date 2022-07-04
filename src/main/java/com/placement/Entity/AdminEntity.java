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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class AdminEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@SequenceGenerator(name = "admin", initialValue = 101, sequenceName = "admin")
//	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "admin")

	private int adminId;
	
	@Column(nullable=false)
	private String adminName;
	
	@Column(nullable=false)
	private String adminEmail;
	
	@Column(nullable=false)
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<StudentEntity> studentEntity=new ArrayList<StudentEntity>();

	
}
