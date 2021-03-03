package org.springboot.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springboot.jpa.model.Country;
import org.springboot.jpa.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	CountryRepository countryRepository;
	
	@Override
	public List<Country> getAllCountries() {
		 List<Country> countries = new ArrayList<>();
		 countryRepository.findAll().forEach(country->countries.add(country));
		 return countries;
	}
	
}
