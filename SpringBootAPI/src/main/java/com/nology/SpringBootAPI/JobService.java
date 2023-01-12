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
	
	public void update(Long id, Map<String, UpdateJobDTO> data) {
		Optional<Job> j = jobRepository.findById(id);
		
		j.ifPresent(jobMaybe -> {
			if(data.containsKey("name")) {
				jobMaybe.setName(((Job) data).getName());
			};
			if(data.containsKey("name")) {
				jobMaybe.setStartDate(((Job) data).getStartDate());
			};
			if(data.containsKey("name")) {
				jobMaybe.setEndDate(((Job) data).getEndDate());
			};
			if(data.containsKey("name")) {
				jobMaybe.setName(((Job) data).getName());
			};
		
		});
	}
	
	
}
