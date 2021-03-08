package org.springboot.jpa.model;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="department")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id")
	private Long departmentId;
	@Column(name="department_name")
	private String departmentName;
	@Column(name="department_head")
	private String departmentHead;
	
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL,orphanRemoval = true)
	private Set<Student> students;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "colleage_fk",referencedColumnName = "colleage_id")
	@JsonIgnore
	private Colleage colleage;
}
