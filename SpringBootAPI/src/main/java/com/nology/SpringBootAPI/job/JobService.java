package com.nology.SpringBootAPI.job;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nology.SpringBootAPI.temp.Temp;
import com.nology.SpringBootAPI.temp.TempService;

@Service
@Transactional
public class JobService {
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private TempService tempService;
	
	public List<Job> all() {
		return jobRepository.findAll();
	}
	
	public Optional<Job> getJobById(Long id) {
		return jobRepository.findById(id);
	}
	
	public Job create(CreateJobDTO job) throws Exception {
		Job j = new Job();
		j.setName(job.getName());
		if(job.getStartDate().compareTo(j.getEndDate()) < 0) {
			throw new Exception("Start date is later the End date");
		}
		j.setStartDate(job.getStartDate());
		j.setEndDate(job.getEndDate());
		if(job.getTempId() != null) {
			Temp temp = tempService.getTempById(job.getTempId()).get();
			j.setTemp(temp);
		}
        
		jobRepository.save(j);
		
		return j;
	}
	
	public void update(Long id, UpdateJobDTO data) {
		Optional<Job> j = jobRepository.findById(id);
		
		j.ifPresent(jobMaybe -> {
			jobMaybe.setName(data.getName());
			jobMaybe.setStartDate(data.getStartDate());
			jobMaybe.setEndDate(data.getEndDate());
			jobMaybe.setName(data.getName());
			if(data.getTempId() != null) {
				Temp temp = tempService.getTempById(data.getTempId()).get();
				jobMaybe.setTemp(temp);
			}
			
		});
		
	}
	
	public List<Job> isAssigned(Boolean assigned) {
		if(assigned == true) {
			List<Job> list = jobRepository.findAll().stream()
					.filter(job -> job.getTemp() != null)
					.collect(Collectors.toList());
			return list;
		} else {
			
			List<Job> list = jobRepository.findAll().stream()
					.filter(job -> job.getTemp() == null)
					.collect(Collectors.toList());
			return list;
		}
		
		
		
	}
	
	
}
