package org.springboot.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springboot.jpa.model.State;
import org.springboot.jpa.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl implements StateService {

	@Autowired
	StateRepository stateRepository;

	@Override
	public List<State> getAllStates() {
		List<State> states = new ArrayList<>();
		stateRepository.findAll().forEach(state -> states.add(state));
		return states;
	}

	@Override
	public State getStateForId(Long stateId) {
		return stateRepository.findById(stateId).get();
	}

}
