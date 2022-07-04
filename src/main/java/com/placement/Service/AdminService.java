package com.placement.service;

import java.util.List;

import com.placement.payloads.AdminDto;

public interface AdminService
{
	public AdminDto createAdmin(AdminDto adminDto);
	
	public AdminDto getAdminById(int adminId);
	
	public List<AdminDto> getAllAdmins();
	
	public AdminDto updateAdminById(AdminDto adminDto,int adminId);
	
	public void deleteAdminById(int adminId);
	
	

}
