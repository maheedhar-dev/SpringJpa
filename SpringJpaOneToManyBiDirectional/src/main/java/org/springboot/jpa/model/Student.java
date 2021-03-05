package org.springboot.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="student")
@NoArgsConstructor
@Data
public class Student {
	
	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentId;
	@Column(name="student_name")
	private String studentName;
	@Column(name = "student_address")
	private String  studentAddress;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_fk",referencedColumnName = "department_id")
	Department department;
}
