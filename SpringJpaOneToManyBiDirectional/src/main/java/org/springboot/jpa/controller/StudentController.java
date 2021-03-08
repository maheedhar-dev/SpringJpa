package org.springboot.jpa.controller;

import java.net.URI;
import java.util.List;

import org.springboot.jpa.exception.ColleageDataException;
import org.springboot.jpa.model.Student;
import org.springboot.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<Student> getStudentForId(@PathVariable Long studentId) throws ColleageDataException{
		if(studentId==null) {
			throw new ColleageDataException("StudentId should not be empty");
		}
		
		Student student = studentService.findStudentById(studentId);
		if(student==null || student.getStudentId()==0) {
			throw new ColleageDataException("Cannot find student with studentId "+studentId);
		}
		
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}
	
	@PostMapping("/department/students/{departmentId}")
	public ResponseEntity<?> saveStudentForDepartment(@PathVariable Long departmentId,@RequestBody Student student) throws ColleageDataException{
		
		System.out.println("departmentId:"+departmentId);
		
		if(departmentId==null||student==null||departmentId==0) {
			throw new ColleageDataException("No data is available in the requestbody please check your request");
		}
		
		Student savedStudent = studentService.saveStudentForDepartment(student, departmentId);
		
		if(savedStudent==null||savedStudent.getStudentId()<=0) {
			throw new ColleageDataException("Unable to save the student data.Plese contact the admin");
		}
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(departmentId).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
