package com.testeatech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.testeatech.entity.Flight;
import com.testeatech.service.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightController extends AbstractController<Flight, Long>{

	@Autowired
	private FlightService service;
	
	public FlightController(FlightService service) {
		super(service);
		this.service = service;
	}
	
	@RequestMapping(value = "/saveFlight", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Flight saveFlight(@RequestBody Flight entity) {

		return service.save(entity);
	}
	
	@RequestMapping(value = "/updateFlight", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Flight updateFlight(@RequestBody Flight entity) {

		return service.update(entity);
	}
	
	@RequestMapping(value = "/getAllByOrderByNumberAsc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Flight> getAllByOrderByNumber() {

		return service.findAllByOrderByNumber();
	}
	
	@RequestMapping(value = "/getAllByNumber/{number}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Flight> getAllByNumber(@PathVariable("number") String number) {

		return service.findAllByNumber(number);
	}
	
	@RequestMapping(value = "/getAllByFrom/{from}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Flight> getAllByFrom(@PathVariable("from") String from) {

		return service.findAllByFrom_Name(from);
	}
	
	@RequestMapping(value = "/getAllByTo/{to}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Flight> getAllByTo(@PathVariable("to") String to) {

		return service.findAllByTo_Name(to);
	}
	
	@RequestMapping(value = "/deleteFlight/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public void deleteFlight(@PathVariable("id") Long id){
		
		Flight entity = service.findOne(id);
		
		if(entity != null){
			
			service.delete(entity);
		}
	}
	
	@RequestMapping(value = "/getFlight/{id}", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Flight getFlight(@PathVariable("id") Long id){
		
		return service.findOne(id);
				
	}
	
}
