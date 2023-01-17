package com.nology.SpringBootAPI;

import java.util.Date;


import jakarta.validation.constraints.NotNull;

public class CreateJobDTO {
	
	@NotNull
	private String name;
	@NotNull
	private Date startDate;
	@NotNull
	private Date endDate;
	private Long tempId;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getStartDate() {
		return startDate; 
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Long getTempId() {
		return tempId;
	}
	public void setTemp(Long tempId) {
		this.tempId = tempId;
	}
}
