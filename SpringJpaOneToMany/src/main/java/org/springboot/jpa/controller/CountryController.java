package org.springboot.jpa.controller;

import java.util.List;

import org.springboot.jpa.exception.DataException;
import org.springboot.jpa.model.Country;
import org.springboot.jpa.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	@GetMapping("/getAllCountries")
	public ResponseEntity<List<Country>> getAllCountries() throws DataException{
		List<Country> countries = countryService.getAllCountries();
		if(countries==null|| countries.size()<=0) {
			throw new  DataException("No Countires are available in the Database please contact admin");
		}
		
		return  new ResponseEntity<List<Country>>(countries, HttpStatus.OK);
	}
}
