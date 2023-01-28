package com.nology.SpringBootAPI.temp;

import java.util.List;
import java.util.Optional;

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

import com.nology.SpringBootAPI.job.Job;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/temps")
public class TempController {
	@Autowired
	private TempService tempService;
	
	@GetMapping
	public ResponseEntity<List<Temp>> getTemps(@RequestParam(value = "jobId", required = false) Long jobId) {
		if(jobId != null) {
			List<Temp> list = tempService.checkJobs(jobId);
			if(list.size() == 0) {
				return ResponseEntity.noContent().build();
			} else {
				return ResponseEntity.ok(list);
			}
		} else {	
			return ResponseEntity.ok(tempService.all());
		}		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Temp> getTemp(@PathVariable Long id) {
		Optional<Temp> temp = tempService.getTempById(id);
		if(temp.isPresent()) {
			return ResponseEntity.ok(temp.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	} 
	 
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public void saveTemp(@Valid @RequestBody CreateTempDTO tempDTO) {
		tempService.create(tempDTO);
	}
	
	@PatchMapping("/{id}")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	public ResponseEntity<Temp> updateTemp(@PathVariable Long id, @Valid @RequestBody UpdateTempDTO tempDTO) {
		
		Optional<Temp> optionalTemp = tempService.getTempById(id);
		if (optionalTemp.isPresent()) {
			try {
				tempService.update(id, tempDTO);
				return ResponseEntity.ok(optionalTemp.get());
			} catch (Exception e) {
				return ResponseEntity.badRequest().header(e.getMessage()).build();
			}
	        
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@GetMapping("/test")
	public boolean getTheTemp() {
		return tempService.test();
		
	} 
	
	
}
