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
public class AdminDto 
{
     private int adminId;
	
	private String adminName;
	
	private String adminEmail;
	
	private String password;
	
	private List<StudentDto> studentEntity;

}
