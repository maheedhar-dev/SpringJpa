package org.springboot.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springboot.jpa.model.Colleage;
import org.springboot.jpa.model.Department;
import org.springboot.jpa.model.Student;
import org.springboot.jpa.repositories.ColleageRepository;
import org.springboot.jpa.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	ColleageRepository colleageRepository;
	
	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments = new ArrayList<>();
		 departmentRepository.findAll().forEach(department->departments.add(department));
		return departments;
	}

	@Override
	public Set<Student> getAllStudentsForDepartment(Long departmentId) {
		return  departmentRepository.findById(departmentId).get().getStudents();
	}

	@Override
	public Department findDepartmentById(Long departmentId) {
		return departmentRepository.findById(departmentId).get();
	}

	@Override
	public Department saveDepartmentForColleage(Department department, Long colleageId) {
		Colleage savedColleage = colleageRepository.findById(colleageId).get();
		department.setColleage(savedColleage);
		Department savedDepartment = departmentRepository.save(department);
		return savedDepartment;
	}

	
}
