package org.springboot.jpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="department")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id")
	private Long departmentId;
	@Column(name="department_name")
	private String departmentName;
	@Column(name="department_head")
	private String departmentHead;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "colleage_fk",referencedColumnName = "colleage_id")
	Colleage colleage;
	
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL,orphanRemoval = true)
	Set<Student> students = new HashSet<>();
}
