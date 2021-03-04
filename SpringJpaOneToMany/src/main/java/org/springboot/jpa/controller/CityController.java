package org.springboot.jpa.controller;

import java.util.List;

import org.springboot.jpa.exception.DataException;
import org.springboot.jpa.model.City;
import org.springboot.jpa.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityController {
	
	@Autowired
	CityService cityService;
	
	@GetMapping("/getAllCities")
	public ResponseEntity<List<City>> getAllCities() throws DataException{
		List<City> cities = cityService.getAllCities();
		if(cities==null|| cities.size()<=0) {
			throw new  DataException("No cities are available in the Database please contact admin");
		}
		
		return  new ResponseEntity<List<City>>(cities, HttpStatus.OK);
	}
	
	@GetMapping("/city/{cityId}")
	public ResponseEntity<City> getCountryForId(@PathVariable Long cityId) throws DataException{
		City city = cityService.getCityForId(cityId);
		if(city==null) {
			throw new DataException("No city found with the id: "+cityId);
		}
		return new ResponseEntity<City>(city,HttpStatus.OK);
	}
	
 
}
