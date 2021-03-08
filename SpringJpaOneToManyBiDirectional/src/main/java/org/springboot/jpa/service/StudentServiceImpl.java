package org.springboot.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springboot.jpa.model.Department;
import org.springboot.jpa.model.Student;
import org.springboot.jpa.repositories.DepartmentRepository;
import org.springboot.jpa.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public Student findStudentById(Long studentId) {
		
		return studentRepository.findById(studentId).get();
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> studentsList = new ArrayList<>(); 
		 studentRepository.findAll().forEach(student->studentsList.add(student));
		return studentsList;
	}

	@Override
	public Student saveStudentForDepartment(Student student, Long departmentId) {
		 Department savedDepartmet = departmentRepository.findById(departmentId).get();
		 student.setDepartment(savedDepartmet);
		return studentRepository.save(student);
	}
	
	
	
}
