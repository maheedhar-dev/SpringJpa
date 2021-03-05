package org.springboot.jpa.service;

import org.springboot.jpa.model.Colleage;
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

}
