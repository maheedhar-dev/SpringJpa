package org.springboot.jpa.controller;

import java.net.URI;
import java.util.List;
import java.util.Set;

import org.springboot.jpa.exception.ColleageDataException;
import org.springboot.jpa.model.Colleage;
import org.springboot.jpa.model.Department;
import org.springboot.jpa.service.ColleageService;
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
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{colleageId}").buildAndExpand(savedColleage.getColleageId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/colleage/{colleageId}")
	public ResponseEntity<Colleage> getColleage(@PathVariable Long colleageId) throws ColleageDataException{
		System.out.println("In Student controller");
		if(colleageId==null) {
			throw new ColleageDataException("ColleageId should not be null");
		}
		
		Colleage colleage = colleageService.getColleageForId(colleageId);
		if(colleage==null) {
			throw new ColleageDataException("Colleage is not availble please contact the admin or check the colleageId");
		}
		
		return new ResponseEntity<Colleage>(colleage,HttpStatus.OK);
		
		
	}

	@GetMapping("/colleage/departments/{colleageId}")
	public ResponseEntity<Set<Department>> getDepartmentsForColleage(@PathVariable Long colleageId) throws ColleageDataException{
		if(colleageId==null) {
			throw new ColleageDataException("ColleageId should not be null");
		}
			Set<Department> departments = colleageService.getDepartmentsForColleageId(colleageId);
			
			if(departments==null) {
				throw new ColleageDataException("Departments is not availble for the given colleageId please contact the admin or check the colleageId");
			}
			
			return new ResponseEntity<Set<Department>>(departments,HttpStatus.OK);
	}
	
	@GetMapping("/colleages")
	public ResponseEntity<List<Colleage>> getAllColleages() throws ColleageDataException{
		List<Colleage> colleages = colleageService.getAllColleages();
		if(colleages==null) {
			throw new ColleageDataException("No Colleages are available in DB.Please contact the Admin");
		}
		return new ResponseEntity<List<Colleage>>(colleages,HttpStatus.OK);
	}
	
}
