package com.nology.SpringBootAPI.temp;

import java.util.Date;

import jakarta.validation.constraints.NotNull;

public class UpdateTempDTO {
	
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;

	
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
}
