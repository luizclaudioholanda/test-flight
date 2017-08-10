package com.testeatech.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.testeatech.entity.Airport;
import com.testeatech.entity.Flight;
import com.testeatech.entity.Pilot;
import com.testeatech.repository.FlightRepository;
import com.testeatech.service.AbstractGenericTestService;


@RunWith(MockitoJUnitRunner.class)
public class FlightSserviceImplTest extends AbstractGenericTestService<Flight, Long>{
	
	@Mock
	private Flight flight;
	
	@InjectMocks
	private FlightServiceImpl service;
	
	@Mock
	private FlightRepository dao;
	
	private Long identifier = 10L;
	
	@Before
	public void initDaoServiceAndIdentifierToSuper() {
		super.setDao(dao);
		super.setService(service);
		super.setIdentifier(identifier);
		
	}	
	
	@Test
	public void FlightServiceTest(){
		FlightServiceImpl entity = new FlightServiceImpl();
	}
	
	@Override
	public Flight createObjectToTest(Long identifier) {
		
		Flight entity = new Flight();
		entity.setId(identifier);
		entity.setNumber("AZ-5434");
		entity.setStatus("LANDED");
		entity.setFrom(createAirport("TESTE","GRU"));
		entity.setTo(createAirport("NOVO","FOR"));
		entity.setFlightPilot(createPilot("MIKE"));
		
		
		return entity;
	}

	@Override
	public Set<Flight> createList() {
		
		Set<Flight> setUserAccessParam = new HashSet<Flight>();
		Flight p1 = createObjectToTest(20L);
		Flight p2 = createObjectToTest(50L);
		
		setUserAccessParam.add(p1);
		setUserAccessParam.add(p2);
		
		return setUserAccessParam;
	}
	
	private Pilot createPilot(String name){
		
		Pilot p = new Pilot();
		p.setFlightHours(10000L);
		p.setLicense("ZZZZZZ");
		p.setName(name);
		
		return p;
	}
	
	private Airport createAirport(String name, String code){
		
		Airport a = new Airport();
		
		a.setCode(code);
		a.setName(name);
		
		return a;
	}

}
