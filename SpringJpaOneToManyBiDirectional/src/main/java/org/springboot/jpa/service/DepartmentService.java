package org.springboot.jpa.service;

import java.util.List;
import java.util.Set;

import org.springboot.jpa.model.Department;
import org.springboot.jpa.model.Student;

public interface DepartmentService {
	List<Department> getAllDepartments();
	Set<Student> getAllStudentsForDepartment(Long departmentId);
	Department findDepartmentById(Long departmentId);
	Department saveDepartmentForColleage(Department department,Long colleageId);
}
