package com.testeatech.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testeatech.entity.Flight;
import com.testeatech.repository.FlightRepository;
import com.testeatech.service.FlightService;

@Service
public class FlightServiceImpl extends GenericCRUDServiceImpl<Flight, Long> implements FlightService {

	@Autowired
	private FlightRepository repository;
	
	public FlightServiceImpl(){
		
	}
	
	@Autowired
	public FlightServiceImpl(FlightRepository repository) {

		super.setRepository(repository);
	}
	
	@Override
	public List<Flight> findAllByOrderByNumber() {
		return repository.findAllByOrderByNumber();
	}

	@Override
	public List<Flight> findAllByNumber(String number) {
		return repository.findAllByNumber(number);
	}

	@Override
	public List<Flight> findAllByFrom(String from) {
		return repository.findAllByFrom(from);
	}

	@Override
	public List<Flight> findAllByTo(String to) {
		return repository.findAllByTo(to);
	}

	
}
