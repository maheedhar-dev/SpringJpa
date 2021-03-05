package org.springboot.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "colleage")
@NoArgsConstructor
@Data
public class Colleage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="colleage_id")
	private Long colleageId;
	@Column(name="colleage_name")
	private String colleageName;
	@Column(name="colleage_code")
	private String colleageCode;

	@OneToMany(mappedBy = "colleage", cascade = CascadeType.ALL,orphanRemoval = true)
	Set<Department> departments = new HashSet<>();
	
	
}
