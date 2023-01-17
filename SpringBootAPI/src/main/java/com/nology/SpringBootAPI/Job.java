package com.nology.SpringBootAPI;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nology.SpringBootAPI.temp.Temp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Date startDate;                        
	private Date endDate;
	
	@ManyToOne
    @JsonManagedReference
	private Temp temp;
	
	public Job() {}
	
	public Job(String name) {
		this.setName(name);
	}
	
	public Job (String name, Date startDate, Date endDate, Temp temp) {
		this.setName(name);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setTemp(temp);
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
	
	public Temp getTemp() {
		return temp;
	}

	public void setTemp(Temp temp) {
		this.temp = temp;
	}

}
