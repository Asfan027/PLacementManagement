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
import com.placement.payloads.AdminDto;
import com.placement.service.AdminService;

@RestController
@RequestMapping("/api")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	//To create admin Resource 
	@PostMapping("/admin")
	public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto)
	{
		AdminDto createAdmin=this.adminService.createAdmin(adminDto);
		return new ResponseEntity<AdminDto>(createAdmin,HttpStatus.CREATED);
	}
	
	//To fetch admin By Id
	@GetMapping("/admin/{adminId}")
	public ResponseEntity<AdminDto> getAdminById(@PathVariable int adminId)
	{
		AdminDto getAdmin=this.adminService.getAdminById(adminId);
		return new ResponseEntity<AdminDto>(getAdmin,HttpStatus.OK);
	}
	
	//To fetch all the admin records as a list
	@GetMapping("/admin")
	public ResponseEntity<List<AdminDto>> getAllAdmins()
	{
		List<AdminDto> getAdmins=this.adminService.getAllAdmins();
		return new ResponseEntity<List<AdminDto>>(getAdmins,HttpStatus.OK);
	}
	
	//To Update admin record by admin id
	@PutMapping("/admin/{adminId}")
	public ResponseEntity<AdminDto> updateAdminById(@RequestBody AdminDto adminDto,@PathVariable int adminId)
	{
		AdminDto updateAdmin=this.adminService.updateAdminById(adminDto, adminId);
		return new ResponseEntity<AdminDto>(updateAdmin,HttpStatus.OK);
	}
	
	//To delete admin by id
	@DeleteMapping("/admin/{adminId}")
	public ResponseEntity<ApiResponse> deleteAdminById(@PathVariable int adminId)
	{
		this.adminService.deleteAdminById(adminId);
		ApiResponse response = new ApiResponse();
		response.setMessage("Admin Details will be deleted");
		response.setSuccess(true);
		return new ResponseEntity<ApiResponse>(response,HttpStatus.OK);
	}

}
