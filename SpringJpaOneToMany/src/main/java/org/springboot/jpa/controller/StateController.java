package org.springboot.jpa.controller;

import java.util.List;

import org.springboot.jpa.exception.DataException;
import org.springboot.jpa.model.State;
import org.springboot.jpa.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateController {
	
	@Autowired
	StateService stateService;
	
	@GetMapping("/getAllStates")
	public ResponseEntity<List<State>> getAllStates() throws DataException{
		List<State> states = stateService.getAllStates();
		if(states==null|| states.size()<=0) {
			throw new  DataException("No states are available in the Database please contact admin");
		}
		
		return  new ResponseEntity<List<State>>(states, HttpStatus.OK);
	}
	
	@GetMapping("/state/{stateId}")
	public ResponseEntity<State> getCountryForId(@PathVariable Long stateId) throws DataException{
		State state = stateService.getStateForId(stateId);
		if(state==null) {
			throw new DataException("No State found with the id: "+stateId);
		}
		return new ResponseEntity<State>(state,HttpStatus.OK);
	}
	
 
}
