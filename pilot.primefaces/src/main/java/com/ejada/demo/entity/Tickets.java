//package com.ejada.demo.entity;
//
//import java.sql.Time;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//
//@Entity
//public class Tickets {
//	//one-way tickets
//	
//	@Id @GeneratedValue 
//	private int ticket_id; // PK
//	private String departure_city;
//	private Date departure_day;
//	private long departure_time;
//	
//	private String arrival_city;
//	private Date arrival_day;
//	private long arrival_time;
////	@Column(nullable = false)
//	private int price;
//	
//	@OneToOne
//	private Airplane airplane;
//	
//	@ManyToOne
//	private Traveler_User user;
//	
//	@OneToOne
//	private Admin admin;
//	
//    @Enumerated(EnumType.STRING)
//    private TicketType ticketType;
//
//    public enum TicketType {
//        Economy,
//        Business,
//        FirstClass
//    }
//
//	public int getTicket_id() {
//		return ticket_id;
//	}
//
//	public void setTicket_id(int ticket_id) {
//		this.ticket_id = ticket_id;
//	}
//
//	public String getDeparture_city() {
//		return departure_city;
//	}
//
//	public void setDeparture_city(String departure_city) {
//		this.departure_city = departure_city;
//	}
//
//	public Date getDeparture_day() {
//		return departure_day;
//	}
//
//	public void setDeparture_day(Date departure_day) {
//		this.departure_day = departure_day;
//	}
//
//	public long getDeparture_time() {
//		return departure_time;
//	}
//
//	public void setDeparture_time(long departure_time) {
//		this.departure_time = departure_time;
//	}
//
//	public String getArrival_city() {
//		return arrival_city;
//	}
//
//	public void setArrival_city(String arrival_city) {
//		this.arrival_city = arrival_city;
//	}
//
//	public Date getArrival_day() {
//		return arrival_day;
//	}
//
//	public void setArrival_day(Date arrival_day) {
//		this.arrival_day = arrival_day;
//	}
//
//	public long getArrival_time() {
//		return arrival_time;
//	}
//
//	public void setArrival_time(long arrival_time) {
//		this.arrival_time = arrival_time;
//	}
//
//	public int getPrice() {
//		return price;
//	}
//
//	public void setPrice(int price) {
//		this.price = price;
//	}
//
//	public Airplane getAirplane() {
//		return airplane;
//	}
//
//	public void setAirplane(Airplane airplane) {
//		this.airplane = airplane;
//	}
//
//	public Traveler_User getUser() {
//		return user;
//	}
//
//	public void setUser(Traveler_User user) {
//		this.user = user;
//	}
//
//	public Admin getAdmin() {
//		return admin;
//	}
//
//	public void setAdmin(Admin admin) {
//		this.admin = admin;
//	}
//
//	public TicketType getTicketType() {
//		return ticketType;
//	}
//
//	public void setTicketType(TicketType ticketType) {
//		this.ticketType = ticketType;
//	}
//
//
//    
//
//}
