package org.springboot.jpa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springboot.jpa.model.Colleage;
import org.springboot.jpa.model.Department;
import org.springboot.jpa.repositories.ColleageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColleageServiceImpl implements ColleageService {

	@Autowired
	ColleageRepository colleageRepository;
	
	@Override
	public Colleage saveColleage(Colleage colleage) {
		return colleageRepository.save(colleage);
	}

	@Override
	public Colleage getColleageForId(Long colleageId) {
		return colleageRepository.findById(colleageId).get();
	}

	@Override
	public List<Colleage> getAllColleages() {
		List<Colleage> colleages = new ArrayList<Colleage>();
		 colleageRepository.findAll().forEach(colleage->colleages.add(colleage)); 
		 return colleages;
	}

	@Override
	public Set<Department> getDepartmentsForColleageId(Long colleageId) {
		// TODO Auto-generated method stub
		return colleageRepository.findById(colleageId).get().getDepartments();
	}
	
	
}
