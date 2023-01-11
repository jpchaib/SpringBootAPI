package com.nology.SpringBootAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepository repository;
	
	public List<Student> all() {
		return repository.findAll();
	}
	
	public void create(StudentDTO student) {
		Student s = new Student(student.getFullname(), student.getCohort());
		repository.save(s);
	}
	
	
}
