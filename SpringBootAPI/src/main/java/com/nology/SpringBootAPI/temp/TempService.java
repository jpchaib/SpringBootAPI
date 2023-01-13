package com.nology.SpringBootAPI.temp;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TempService {
	@Autowired
	private TempRepository tempRepository;
	
	public List<Temp> all() {
		return tempRepository.findAll();
	}
	
	public void create(CreateTempDTO temp) {
		Temp t = new Temp(temp.getFirstName(), temp.getLastName());
		tempRepository.save(t);
	}
	
	public void update(Long id, UpdateTempDTO data) {
		Optional<Temp> t = tempRepository.findById(id);
		
		t.ifPresent(tempMaybe -> {
			tempMaybe.setFirstName(data.getFirstName());
			tempMaybe.setLastName(data.getLastName());	
		});
	}
	
	
}
