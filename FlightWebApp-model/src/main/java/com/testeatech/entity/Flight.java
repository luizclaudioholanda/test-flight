package com.testeatech.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_FLIGHT")
public class Flight implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2929282711807039108L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String number;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AIRPORT_FROM_ID", nullable = false)
	private Airport from;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AIRPORT_TO_ID", nullable = false)
	private Airport to;
	
	private String status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PILOT_ID", nullable = false)
	private Pilot flightPilot;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "AIRCRAFT_ID", nullable = false)
	private Aircraft aircraft;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Airport getFrom() {
		return from;
	}

	public void setFrom(Airport from) {
		this.from = from;
	}

	public Airport getTo() {
		return to;
	}

	public void setTo(Airport to) {
		this.to = to;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Pilot getFlightPilot() {
		return flightPilot;
	}

	public void setFlightPilot(Pilot flightPilot) {
		this.flightPilot = flightPilot;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}
	
	
	
}
