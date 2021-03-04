package org.springboot.jpa.service;

import java.util.List;

import org.springboot.jpa.model.State;

public interface StateService {
	List<State> getAllStates();
	State getStateForId(Long stateId);
}
