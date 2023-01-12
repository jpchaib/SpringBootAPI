package com.nology.SpringBootAPI;

import java.util.Date;

import jakarta.validation.constraints.NotNull;

public class UpdateJobDTO {
	
	@NotNull
	private String name;
	@NotNull
	private Date startDate;
	@NotNull
	private Date endDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
