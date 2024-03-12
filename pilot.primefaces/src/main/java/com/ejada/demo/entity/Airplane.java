package com.ejada.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@NamedQuery(name="getAirplane.byName", query = "from Airplane where airplane_name=:air")
@Entity
public class Airplane {
	

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int airplane_id; // PK
	@Column(unique = true ,nullable = false)
	private String airplane_name;
	private int number_of_seats;
//	private int booked_seats;

	
	public Airplane() {
	//	this.booked_seats=0;
		
	}
	public int getAirplane_id() {
		return airplane_id;
	}
	public void setAirplane_id(int airplane_id) {
		this.airplane_id = airplane_id;
	}
	public String getAirplane_name() {
		return airplane_name;
	}
	public void setAirplane_name(String airplane_name) {
		this.airplane_name = airplane_name;
	}
	public int getNumber_of_seats() {
		return number_of_seats;
	}
	public void setNumber_of_seats(int number_of_seats) {
		this.number_of_seats = number_of_seats;
	}
//	public int getBooked_seats() {
//		return booked_seats;
//	}
//	public void setBooked_seats(int booked_seats) {
//		this.booked_seats = booked_seats;
//	}
//	
	
	

}
