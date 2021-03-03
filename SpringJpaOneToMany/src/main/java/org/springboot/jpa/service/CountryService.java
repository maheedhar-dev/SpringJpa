package org.springboot.jpa.service;

import java.util.List;

import org.springboot.jpa.model.Country;

public interface CountryService {
	
	List<Country> getAllCountries();
	
}
