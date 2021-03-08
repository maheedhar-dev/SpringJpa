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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="student")
@NoArgsConstructor
@Setter
@Getter
@ToString
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
	@JsonIgnore
	private Department department;
}
