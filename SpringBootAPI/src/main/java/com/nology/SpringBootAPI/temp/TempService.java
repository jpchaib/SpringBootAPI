package com.nology.SpringBootAPI.temp;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nology.SpringBootAPI.Job;
import com.nology.SpringBootAPI.JobRepository;

@Service
@Transactional
public class TempService {
	
	@Autowired
	private TempRepository tempRepository;
	@Autowired
	private JobRepository jobRepository;
	
	public List<Temp> all() {
		return tempRepository.findAll();
	}
	
	public Optional<Temp> getTempById(Long id) {
		return tempRepository.findById(id);
	
	}
	
	public void create(CreateTempDTO temp) {
		Temp t = new Temp(); 
		t.setFirstName(temp.getFirstName());
		t.setLastName(temp.getLastName());
		if(temp.getJobsId() != null) {
			List<Long> jobsId = temp.getJobsId();
			List<Job> jobs = jobsId.stream().map(jobId -> jobRepository.findById(jobId).get()).collect(Collectors.toList());
			t.setJobs(jobs);
		}
		tempRepository.save(t);
	}
	
	public void update(Long id, UpdateTempDTO data) {
		Optional<Temp> t = tempRepository.findById(id);
		
		t.ifPresent(tempMaybe -> {
			tempMaybe.setFirstName(data.getFirstName());
			tempMaybe.setLastName(data.getLastName());
			if(data.getJobsId() != null) {
				List<Long> jobsId = data.getJobsId();
				List<Job> jobs = jobsId.stream().map(jobId -> jobRepository.findById(jobId).get()).collect(Collectors.toList());
				tempMaybe.setJobs(jobs);
			}
		});
	}
	
	
}
