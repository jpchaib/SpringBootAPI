package com.nology.SpringBootAPI;

import jakarta.validation.constraints.NotNull;

public class StudentDTO {
	
	@NotNull
	private String fullname;
	
	@NotNull
	private String cohort;
	
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
