package org.springboot.jpa.repository;

import org.springboot.jpa.model.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<State, Long>{

}
