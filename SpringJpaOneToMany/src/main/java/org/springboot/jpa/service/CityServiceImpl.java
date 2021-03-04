package org.springboot.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springboot.jpa.model.City;
import org.springboot.jpa.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	CityRepository cityRepository;

	@Override
	public List<City> getAllCities() {
		List<City> cities = new ArrayList<>();
		cityRepository.findAll().forEach(city -> cities.add(city));
		return cities;
	}

	@Override
	public City getCityForId(Long cityId) {
		return cityRepository.findById(cityId).get();
	}

}
