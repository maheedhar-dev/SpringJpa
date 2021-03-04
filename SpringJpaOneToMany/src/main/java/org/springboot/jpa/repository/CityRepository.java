package org.springboot.jpa.repository;

import org.springboot.jpa.model.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends CrudRepository<City, Long>{

}
