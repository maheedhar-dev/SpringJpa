package org.springboot.jpa.service;

import java.util.List;

import org.springboot.jpa.model.City;

public interface CityService {
	List<City> getAllCities();
	City getCityForId(Long cityId);
}
