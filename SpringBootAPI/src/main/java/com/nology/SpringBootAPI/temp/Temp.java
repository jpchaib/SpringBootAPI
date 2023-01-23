package com.nology.SpringBootAPI.temp;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nology.SpringBootAPI.job.Job;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Temp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy = "temp")
    @JsonIgnoreProperties(value = {"temp"})
    private List<Job> jobs;
	
	public Temp() {}
	
	public Temp(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id= id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public List<Job> getJobs() {
		return jobs;
	}
	
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	
}
