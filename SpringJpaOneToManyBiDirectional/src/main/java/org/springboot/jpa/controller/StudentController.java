package org.springboot.jpa.controller;

import java.util.List;

import org.springboot.jpa.exception.ColleageDataException;
import org.springboot.jpa.model.Student;
import org.springboot.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() throws ColleageDataException{
		List<Student> students =  studentService.getAllStudents();
		if(students==null) {
			throw new ColleageDataException("Students are not available.Please contact the admin");
		}
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);
	}
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<Student> getStudentForId(Long studentId) throws ColleageDataException{
		if(studentId==null) {
			throw new ColleageDataException("StudentId should not be empty");
		}
		
		Student student = studentService.findStudentById(studentId);
		if(student==null || student.getStudentId()==0) {
			throw new ColleageDataException("Cannot find student with studentId "+studentId);
		}
		
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
}
