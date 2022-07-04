package com.placement.serviceimplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.placement.entity.AdminEntity;
import com.placement.exception.ResourceNotFoundException;
import com.placement.payloads.AdminDto;
import com.placement.repository.AdminRepository;
import com.placement.repository.StudentRepository;
import com.placement.service.AdminService;
@Service
public class AdminServiceImplementation implements AdminService
{

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	
	private StudentRepository studentRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public AdminDto createAdmin(AdminDto adminDto) 
	{
		AdminEntity adminEntity=this.modelMapper.map(adminDto, AdminEntity.class);
		AdminEntity savedAdmin=this.adminRepository.save(adminEntity); 
		return this.modelMapper.map(savedAdmin, AdminDto.class);
	}


	

	@Override
	public AdminDto getAdminById(int adminId) 
	{
		AdminEntity adminEntity=this.adminRepository.findById(adminId).
				      orElseThrow(()->new ResourceNotFoundException("Admin", "AdminId", adminId));
		return this.modelMapper.map(adminEntity, AdminDto.class);
	}

	@Override
	public List<AdminDto> getAllAdmins()
	{
		List<AdminEntity> adminEntity=this.adminRepository.findAll();
		List<AdminDto> adminDtoList=adminEntity.stream().map(admin->this.modelMapper.map(admin, AdminDto.class)).collect(Collectors.toList());
		return adminDtoList;
	}

	@Override
	public AdminDto updateAdminById(AdminDto adminDto, int adminId) 
	{
		AdminEntity adminEntity=this.adminRepository.findById(adminId).orElseThrow(()->new ResourceNotFoundException("Admin","AdminId",adminId));
		// TODO Auto-generated method stub
		AdminEntity updateAdmin=this.adminRepository.save(this.modelMapper.map(adminDto, AdminEntity.class));
		return this.modelMapper.map(updateAdmin, AdminDto.class);
	}

	@Override
	public void deleteAdminById(int adminId)
	{
		AdminEntity adminEntity=this.adminRepository.findById(adminId).orElseThrow(()->new ResourceNotFoundException("Admin","AdminId",adminId));
		this.adminRepository.delete(adminEntity);
		
	}
	private AdminDto adminEntityToAdminDto(AdminEntity savedAdmin)
	{
		// TODO Auto-generated method stub
		return this.modelMapper.map(savedAdmin, AdminDto.class);
	}


	private AdminEntity adminDtoToAdminEntity(AdminDto adminDto)
	{
		// TODO Auto-generated method stub
		return this.modelMapper.map(adminDto, AdminEntity.class);
	}


}
