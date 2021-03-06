package org.springboot.jpa.service;

import java.util.List;
import java.util.Set;

import org.springboot.jpa.model.Colleage;
import org.springboot.jpa.model.Department;

public interface ColleageService {
	Colleage saveColleage(Colleage colleage);
	
	Colleage getColleageForId(Long colleageId);
	
	List<Colleage> getAllColleages();
	
	Set<Department> getDepartmentsForColleageId(Long colleageId);
}
