package com.nology.SpringBootAPI.temp;

import java.util.List;

import jakarta.validation.constraints.NotNull;

public class CreateTempDTO {
	
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	private List<Long> jobsId;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Long> getJobsId() {
		return jobsId;
	}
	public void setJobsId(List<Long> jobsId) {
		this.jobsId = jobsId;
	}
}
