package com.testeatech.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.testeatech.entity.Flight;

@Repository
public interface FlightRepository extends PagingAndSortingRepository <Flight, Long>{
	
	List<Flight> findAllByOrderByNumber();
	
	List<Flight> findAllByNumber(String number);
	
	List<Flight> findAllByFrom(String from);
	
	List<Flight> findAllByTo(String to);

}
