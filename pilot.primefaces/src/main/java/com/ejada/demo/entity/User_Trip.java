package com.ejada.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User_Trip {
	@Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    @Column(nullable = false)
	private int trip_id;
    @Column(nullable = false)
	private int user_id;
	private int number_of_assigned_seats;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getNumber_of_assigned_seats() {
		return number_of_assigned_seats;
	}
	public void setNumber_of_assigned_seats(int number_of_assigned_seats) {
		this.number_of_assigned_seats = number_of_assigned_seats;
	}
	

	
}
