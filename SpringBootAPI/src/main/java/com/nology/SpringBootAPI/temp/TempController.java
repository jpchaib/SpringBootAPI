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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nology.SpringBootAPI.Job;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/temps")
public class TempController {
	@Autowired
	private TempService tempService;
	
	@GetMapping
	public List<Temp> getTemps() {
		return tempService.all();
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
	public void updateJob(@PathVariable Long id, @Valid @RequestBody UpdateTempDTO tempDTO) {
		tempService.update(id, tempDTO);
	}
	
	
}
