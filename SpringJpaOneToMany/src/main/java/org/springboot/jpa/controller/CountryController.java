package org.springboot.jpa.controller;

import java.net.URI;
import java.util.List;

import org.springboot.jpa.exception.DataException;
import org.springboot.jpa.model.Country;
import org.springboot.jpa.service.CountryService;
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
	
	@GetMapping("/country/{countryId}")
	public ResponseEntity<Country> getCountryForId(@PathVariable Long countryId) throws DataException{
		Country country = countryService.getCountryForId(countryId);
		if(country==null) {
			throw new DataException("No Country found with the id: "+countryId);
		}
		return new ResponseEntity<Country>(country,HttpStatus.OK);
	}
	
	@PostMapping("/country")
	public ResponseEntity<?> saveCountry(@RequestBody Country country) throws DataException{
		Country savedCountry = countryService.saveCountry(country);
		if(savedCountry==null) {
			throw new DataException("country not saved please contact the admin");
		}
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{countryId}").buildAndExpand(savedCountry.getCountryId()).toUri();
		 return ResponseEntity.created(location).build();
	}
}
