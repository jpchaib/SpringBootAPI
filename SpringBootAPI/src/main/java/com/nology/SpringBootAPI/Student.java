package com.nology.SpringBootAPI;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fullname;
	private String cohort;
	
	public Student(String name, String cohort) {
		this.setFullname(name);
		this.setCohort(cohort);
	}
	
	public Student () {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id= id;
	}
	
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getCohort() {
		return cohort;
	}

	public void setCohort(String cohort) {
		this.cohort = cohort;
	}
}
