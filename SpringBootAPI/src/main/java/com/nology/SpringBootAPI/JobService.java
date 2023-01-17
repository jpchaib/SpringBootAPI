package com.nology.SpringBootAPI;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nology.SpringBootAPI.temp.Temp;
import com.nology.SpringBootAPI.temp.TempRepository;

@Service
@Transactional
public class JobService {
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private TempRepository tempRepository;
	
	
	
	public List<Job> all() {
		return jobRepository.findAll();
	}
	
	public Optional<Job> getJobById(Long id) {
		return jobRepository.findById(id);
	
	}
	
	public void create(CreateJobDTO job) {
		Job j = new Job();
		j.setName(job.getName());
		j.setStartDate(job.getStartDate());
		j.setEndDate(job.getEndDate());
		if(job.getTempId() != null) {
			Temp temp = tempRepository.findById(job.getTempId()).get();
			j.setTemp(temp);
		}
        
		jobRepository.save(j);
	}
	
	public void update(Long id, UpdateJobDTO data) {
		Optional<Job> j = jobRepository.findById(id);
		
		j.ifPresent(jobMaybe -> {
			jobMaybe.setName(data.getName());
			jobMaybe.setStartDate(data.getStartDate());
			jobMaybe.setEndDate(data.getEndDate());
			jobMaybe.setName(data.getName());
			if(data.getTempId() != null) {
				Temp temp = tempRepository.findById(data.getTempId()).get();
				jobMaybe.setTemp(temp);
			}
			
		});
		
	}
	
	
}
