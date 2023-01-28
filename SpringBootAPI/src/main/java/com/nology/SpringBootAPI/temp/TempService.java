package com.nology.SpringBootAPI.temp;

import java.util.Date;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nology.SpringBootAPI.job.Job;
import com.nology.SpringBootAPI.job.JobService;

@Service
@Transactional
public class TempService {
	
	@Autowired
	private TempRepository tempRepository;

	private JobService jobService;
	
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
		tempRepository.save(t);
	}
	
	public void update(Long id, UpdateTempDTO data) throws Exception {
		
		Optional<Temp> t = tempRepository.findById(id);
				
		t.ifPresent(tempMaybe -> {
			tempMaybe.setFirstName(data.getFirstName());
			tempMaybe.setLastName(data.getLastName());
			if(data.getJobsId() != null) {
				List<Long> jobsId = data.getJobsId();
				List<Job> jobs = jobsId.stream().map(jobId -> jobService.getJobById(jobId).get()).collect(Collectors.toList());
				
				tempMaybe.setJobs(jobs);
			}
		});
	}
	
	public List<Temp> checkJobs(Long jobId) {
		List<Temp> list = tempRepository.findAll().stream()
                		.filter(temp -> temp.getJobs().stream()
                				.anyMatch(job -> job.getId().equals(jobId)))
                		.collect(Collectors.toList());
		return list;
	}
	
	public boolean test() {
		return tempRepository.checkDates(1, new Date(0), new Date(0));
		
	}
	
	
	
}
