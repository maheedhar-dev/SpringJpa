package org.springboot.jpa.controller;

import java.net.URI;

import org.springboot.jpa.exception.ColleageDataException;
import org.springboot.jpa.model.Colleage;
import org.springboot.jpa.service.ColleageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ColleageController {

	@Autowired
	ColleageService colleageService;
	
	@PostMapping("/colleage")
	public ResponseEntity<?> saveColleage(@RequestBody Colleage colleage) throws ColleageDataException{
		if(colleage==null) {
			throw new ColleageDataException("Request Body doesnot contain the required Data");
		}
		
		colleage.getDepartments().forEach(department->{department.setColleage(colleage);
		                                               department.getStudents().forEach(student->student.setDepartment(department));});
		
		Colleage savedColleage = colleageService.saveColleage(colleage);
		if(savedColleage==null||savedColleage.getColleageId()<=0) {
			throw new ColleageDataException("Unable to persist colleage data please contact the admin");
		}
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/colleageId").buildAndExpand(savedColleage.getColleageId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
