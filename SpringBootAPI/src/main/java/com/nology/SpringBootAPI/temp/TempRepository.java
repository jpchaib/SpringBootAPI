package com.nology.SpringBootAPI.temp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TempRepository extends JpaRepository<Temp,Long> {
	
}
