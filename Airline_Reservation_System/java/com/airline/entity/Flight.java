package com.airline.entity;

import java.time.LocalDate;

public class Flight {
	private int id;
	private String flightNumber;
	private String source;
	private String destination;
	private LocalDate flight_date;
	private double price;
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}

	public Flight(int id, String flightNumber, String source, String destination, LocalDate flight_date, double price) {
		super();
		this.id = id;
		this.flightNumber = flightNumber;
		this.source = source;
		this.destination = destination;
		this.flight_date = flight_date;
		this.price = price;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getFlight_date() {
		return flight_date;
	}

	public void setFlight_date(LocalDate flight_date) {
		this.flight_date = flight_date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", source=" + source + ", destination="
				+ destination + ", flight_date=" + flight_date + ", price=" + price + "]";
	}

}
