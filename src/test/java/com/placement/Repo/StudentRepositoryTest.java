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

import com.placement.entity.StudentEntity;
import com.placement.repository.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentRepositoryTest
{

	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	@Order(1)
	public void saveStudenttest()
	{
		StudentEntity student=StudentEntity.builder()
				              .studentName("Aruna")
				              .studentEmail("aruna@gmail.com")
				              .studentContact("1234786532")
				              .studentQualification("Bsc")
				              .password("12345").build();
		studentRepository.save(student);
		Assertions.assertThat(student.getStudentId()).isGreaterThan(0);
		
	}
	@Test
	@Order(1)
	public void getStudentById()
	{
		StudentEntity student=studentRepository.findById(101).get();
		Assertions.assertThat(student.getStudentId()).isGreaterThan(0);
	}
	@Test
	@Order(2)
	public void getStudentList()
	{
		List<StudentEntity> student=this.studentRepository.findAll();
		Assertions.assertThat(student.size()).isGreaterThan(0);
	}
	@Test
	@Order(3)
	public void updateStudent()
	{
		StudentEntity student=studentRepository.findById(102).get();
		student.setStudentEmail("aruna@gmail.com");
		StudentEntity student1=studentRepository.save(student);
		Assertions.assertThat(student1.getStudentEmail()).isEqualTo("aruna@gmail.com");
	}
	@Test
	@Order(5)
	public void deleteStudent()
	{
		 StudentEntity student = studentRepository.findById(102).get();
		 studentRepository.delete(student);
		  StudentEntity student1=null;
		  Optional<StudentEntity> optionalStudent=studentRepository.findBystudentEmail("aruna@gmail.com");
		  if(optionalStudent.isPresent())
		  {
			  student1=optionalStudent.get();
			  
		  }
		  Assertions.assertThat(student1).isNull();
	}
	
}
