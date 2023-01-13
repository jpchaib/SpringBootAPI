package com.nology.SpringBootAPI;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class JobService {
	@Autowired
	private JobRepository jobRepository;
	
	public List<Job> all() {
		return jobRepository.findAll();
	}
	
	public void create(CreateJobDTO job) {
		Job j = new Job(job.getName(), job.getStartDate(), job.getEndDate());
		jobRepository.save(j);
	}
	
	public void update(Long id, UpdateJobDTO data) {
		Optional<Job> j = jobRepository.findById(id);
		
		j.ifPresent(jobMaybe -> {
			jobMaybe.setName(data.getName());
			jobMaybe.setStartDate(data.getStartDate());
			jobMaybe.setEndDate(data.getEndDate());
			jobMaybe.setName(data.getName());
		});
	}
	
	
}
