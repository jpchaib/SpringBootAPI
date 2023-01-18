package com.nology.SpringBootAPI;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/jobs")
public class JobController {
	@Autowired
	private JobService jobService;
	
	@GetMapping
	public List<Job> getJobs(@RequestParam(value = "assigned", required = false) Boolean assigned) {
		if(assigned != null && assigned == true) {
			List<Job> list = jobService.all().stream()
					.filter(job -> job.getTemp() != null)
					.collect(Collectors.toList());
			return list;
		} else if(assigned != null && assigned == false) {
			List<Job> list = jobService.all().stream()
					.filter(job -> job.getTemp() == null)
					.collect(Collectors.toList());
			return list;
		} else {
			
			return jobService.all();
		}	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Job> getJob(@PathVariable Long id) {
		Optional<Job> job = jobService.getJobById(id);
		if(job.isPresent()) {
			return ResponseEntity.ok(job.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	} 
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveJob(@Valid @RequestBody CreateJobDTO jobDTO) {
		jobService.create(jobDTO);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public ResponseEntity<Job> updateJob(@PathVariable Long id, @Valid @RequestBody UpdateJobDTO jobDTO) {
		
		Optional<Job> optionalJob = jobService.getJobById(id);
		if (optionalJob.isPresent()) {
			jobService.update(id, jobDTO);
	        return ResponseEntity.ok(optionalJob.get());

	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	
}
