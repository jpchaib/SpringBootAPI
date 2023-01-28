package com.nology.SpringBootAPI.temp;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nology.SpringBootAPI.job.Job;


public interface TempRepository extends JpaRepository<Temp,Long> {
	
	  @Query("SELECT CASE WHEN COUNT(j) = 0 THEN true ELSE false END FROM Temp t JOIN t.jobs j WHERE j.startDate < :startDate AND :startDate < j.endDate AND j.startDate < :endDate AND :endDate < j.endDate AND t.id = :id")
	    boolean checkDates(@Param("id") int id, @Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
}
