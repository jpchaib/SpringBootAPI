package com.nology.SpringBootAPI;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/jobs")
public class JobController {
	@Autowired
	private JobService jobService;
	
	@GetMapping
	public List<Job> getJobs() {
		return jobService.all();
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveJob(@Valid @RequestBody CreateJobDTO jobDTO) {
		jobService.create(jobDTO);
	}
	
//	@PatchMapping("/{id}")
//	@ResponseStatus(value = HttpStatus.ACCEPTED)
//	public void updateJob(@PathVariable Long id, @Valid @RequestBody UpdateJobDTO jobDTO) {
//		jobService.update(id, jobDTO);
//	}
	
	
}
