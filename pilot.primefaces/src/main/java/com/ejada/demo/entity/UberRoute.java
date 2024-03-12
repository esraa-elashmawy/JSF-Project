package com.ejada.demo.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.Entity;

@NamedQuery(name="UberRoute.getAll", query = "from UberRoute")
@Entity
public class UberRoute {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ticket_id; // PK
    @Column(nullable = false)
	private String departure_city;
    @Column(nullable = false)
	private Date departure_day;
    @Column(nullable = false)
	private String arrival_city;
    @Column(nullable = false)
	private int price;
	private int booked_seats;
	
	@OneToOne
	private Airplane airplane;
	
//	@ManyToMany
//	private Collection<Traveler_User> user = new ArrayList<Traveler_User>();
//	private Traveler_User user;
	
	@OneToOne
	private Admin admin;
	
	public UberRoute() {
		this.booked_seats=0;
	}
	

	public int getBooked_seats() {
		return booked_seats;
	}

	public void setBooked_seats(int booked_seats) {
		this.booked_seats = booked_seats;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getDeparture_city() {
		return departure_city;
	}

	public void setDeparture_city(String departure_city) {
		this.departure_city = departure_city;
	}

	public Date getDeparture_day() {
		return departure_day;
	}

	public void setDeparture_day(Date departure_day) {
		this.departure_day = departure_day;
	}

	public String getArrival_city() {
		return arrival_city;
	}

	public void setArrival_city(String arrival_city) {
		this.arrival_city = arrival_city;
	}


	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

//	public Traveler_User getUser() {
//		return user;
//	}
//
//	public void setUser(Traveler_User user) {
//		this.user = user;
//	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
	

}
