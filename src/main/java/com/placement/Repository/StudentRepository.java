package com.placement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.entity.StudentEntity;



public interface StudentRepository extends JpaRepository<StudentEntity,Integer>
{

	Optional<StudentEntity> findBystudentEmail(String useremail);

}
