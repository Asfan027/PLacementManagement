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
import com.placement.payloads.StudentDto;
import com.placement.service.StudentService;
@RestController
@RequestMapping("/api")
public class StudentController 
{
	@Autowired
	private StudentService studentService;
	
	//To create a student resources
	@PostMapping("/admin/{adminId}/student")
	public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student,@PathVariable int adminId)
	{
		StudentDto createdstudent = this.studentService.createStudent(student,adminId);
		
		return new ResponseEntity<StudentDto>(createdstudent,HttpStatus.CREATED);
	}
	
	//To fetch all the student records as a list
	@GetMapping("/student")
	public ResponseEntity<List<StudentDto>> getAllStudents()
	{
		List<StudentDto> allStudents = this.studentService.getAllStudents();
		return new ResponseEntity<List<StudentDto>>(allStudents,HttpStatus.OK);
	}
	
	//To fetch particular record by student id
	@GetMapping("/student/{studentId}")
	public ResponseEntity<StudentDto> getStudentById(@PathVariable int studentId)
	{
		StudentDto studentDto = this.studentService.getStudentById(studentId);
		return new ResponseEntity<StudentDto>(studentDto,HttpStatus.OK);
	}
	
	//To update a student record by student id
	@PutMapping("/student/{studentId}")
	public ResponseEntity<StudentDto> updateStudentById(@RequestBody StudentDto student,@PathVariable int studentId)
	{
		StudentDto studentDto = this.studentService.updateStudentById(student, studentId);
		return new ResponseEntity<StudentDto>(studentDto,HttpStatus.OK);
	}
	
	//To delete a student by id
	@DeleteMapping("/student/{studentId}")
	public ResponseEntity<ApiResponse> deleteStudentById(@PathVariable int studentId )
	{
		this.studentService.deleteStudentById(studentId);
		
		return new ResponseEntity<ApiResponse> (new ApiResponse("student is deleted successfully ",true),HttpStatus.OK);
		
	}
	


}
