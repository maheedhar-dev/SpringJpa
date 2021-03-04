package org.springboot.jpa.service;

import java.util.List;

import org.springboot.jpa.model.Country;

public interface CountryService {
	
	List<Country> getAllCountries();
	
	Country saveCountry(Country country);
	
	Country getCountryForId(Long countryId);
	
}
