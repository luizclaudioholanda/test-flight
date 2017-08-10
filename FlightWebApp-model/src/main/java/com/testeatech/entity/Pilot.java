package com.testeatech.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="TB_PILOT")
public class Pilot implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1091618594783656021L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private Long flightHours;
	
	private String license;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "aircraft")
	@JsonIgnore
	private List<Flight> flights;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getFlightHours() {
		return flightHours;
	}

	public void setFlightHours(Long flightHours) {
		this.flightHours = flightHours;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	
}
