package com.testeatech.service;

import java.util.List;

import com.testeatech.entity.Flight;

public interface FlightService extends InterfaceCRUDService<Flight, Long>{

	List<Flight> findAllByOrderByNumber();
	
	List<Flight> findAllByNumber(String number);
	
	List<Flight> findAllByFrom(String from);
	
	List<Flight> findAllByTo(String to);
}
