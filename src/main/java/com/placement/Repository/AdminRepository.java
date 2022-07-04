package com.placement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.entity.AdminEntity;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer>
{

	Optional<AdminEntity> findByadminEmail(String adminemail);

}
