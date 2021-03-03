package org.springboot.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "state_id")
	private Long stateId;
	@Column(name = "state_name")
	private String stateName;
	@Column(name = "state_cpital")
	private String stateCapital;
	@Column(name = "state_code")
	private String stateCode;
	
	public State() {
		// TODO Auto-generated constructor stub
	}
	
	public State(Long stateId, String stateName, String stateCapital, String stateCode) {
		super();
		this.stateId = stateId;
		this.stateName = stateName;
		this.stateCapital = stateCapital;
		this.stateCode = stateCode;
	}

	public Long getStateId() {
		return stateId;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateCapital() {
		return stateCapital;
	}

	public void setStateCapital(String stateCapital) {
		this.stateCapital = stateCapital;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stateCode == null) ? 0 : stateCode.hashCode());
		result = prime * result + ((stateId == null) ? 0 : stateId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (stateCode == null) {
			if (other.stateCode != null)
				return false;
		} else if (!stateCode.equals(other.stateCode))
			return false;
		if (stateId == null) {
			if (other.stateId != null)
				return false;
		} else if (!stateId.equals(other.stateId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", stateName=" + stateName + ", stateCapital=" + stateCapital
				+ ", stateCode=" + stateCode + "]";
	}
	
	
	
}
