package com.nology.SpringBootAPI;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private Date startDate;
	private Date endDate;
//	private Temp temp;
	
	public Job() {}
	
	public Job(String name) {
		this.setName(name);
	}
	
	public Job (String name, Date startDate, Date endDate) {
		this.setName(name);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id= id;
	}
	
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

}
