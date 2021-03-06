package org.springboot.jpa.service;

import java.util.List;

import org.springboot.jpa.model.Student;

public interface StudentService{
	
	Student findStudentById(Long studentId);
	List<Student> getAllStudents();
	
}
