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

import com.placement.entity.AdminEntity;
import com.placement.repository.AdminRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdminRepositoryTest 
{
	@Autowired
	private AdminRepository adminRepository;
	
	@Test
	@Order(1)
	public void saveAdminTest()
	{
		AdminEntity admin=AdminEntity.builder()
				          .adminName("Aruna")
				          .adminEmail("aruna@gmail.com")
				          .password("1234@gmail.com").build();
		adminRepository.save(admin);
		Assertions.assertThat(admin.getAdminId()).isGreaterThan(0);
	}
	@Test
	@Order(2)
	public void getAdminById()
	{
		AdminEntity admin=adminRepository.findById(1).get();
		Assertions.assertThat(admin.getAdminId()).isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void getAdminList()
	{
		List<AdminEntity> admin=adminRepository.findAll();
		Assertions.assertThat(admin.size()).isGreaterThan(0);
	}
	@Test
	@Order(4)
	public void updateAdminById()
	{
		AdminEntity admin=adminRepository.findById(1).get();
		admin.setPassword("aruna@gmail.com");
		AdminEntity admin1=adminRepository.save(admin);
		Assertions.assertThat(admin1.getAdminEmail()).isEqualTo("aruna@gmail.com");
	}

}
