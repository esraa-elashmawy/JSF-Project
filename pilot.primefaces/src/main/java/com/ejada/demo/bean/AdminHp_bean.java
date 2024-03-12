//package com.ejada.demo.bean;
//
//import java.sql.Time;
//import java.util.Date;
//
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//
//import com.ejada.demo.entity.Airplane;
//import com.ejada.demo.entity.Traveler_User;
//import com.ejada.demo.entity.UberRoute;
//import com.ejada.demo.service.UserService;
//
//@ManagedBean(name="admin")
//@SessionScoped
//public class AdminHp_bean {
//	private UserService userService;
//	
//	private String departure_city;
//	private Date departure_day;
//	private Time departure_time;	
//	private String arrival_city;
//	private Date arrival_day;
//	private Time arrival_time;
//	private int price;
//	private String airplane; // airplane id = airplane name
//
//	public AdminHp_bean() {
//		this.userService =new UserService();
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
//	public Time getDeparture_time() {
//		return departure_time;
//	}
//
//	public void setDeparture_time(Time departure_time) {
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
//	public Time  getArrival_time() {
//		return arrival_time;
//	}
//
//	public void setArrival_time(Time arrival_time) {
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
//
//	public String getAirplane() {
//		return airplane;
//	}
//
//	public void setAirplane(String airplane) {
//		this.airplane = airplane;
//	}
//	
//	public Airplane getAir(String airplane_id) {
//		
//		return 	userService.getAir(airplane_id);
//	}
//	  public Time getDepartureTime() {
//	        return new java.sql.Time(departure_time.getTime());
//	    }
//
////	public String addTicket() {
////		System.out.println("airplane is :  "+getAirplane());
////		System.out.println(" begin");
////		System.out.println("airplane date :  "+getArrival_day());
////		Tickets tickets = new Tickets();
////		tickets.setArrival_city(getArrival_city());
////		tickets.setArrival_day(getArrival_day());
////		tickets.setArrival_time(getArrival_day().getTime());
////		tickets.setDeparture_city(getDeparture_city());
////		tickets.setDeparture_day(getDeparture_day());
////		tickets.setDeparture_time(getDeparture_day().getTime());
////		tickets.setAirplane(getAir(getAirplane()));
////		tickets.setPrice(getPrice());
////		
////
////
////	  	userService.persistTicket(tickets);	
////	
////	  	return "sucess2";
////	}
//	
//	public String addTicket() {
//		System.out.println("airplane is :  "+getAirplane());
//		System.out.println(" begin");
//		System.out.println("airplane date :  "+getArrival_day());
//		UberRoute tickets = new UberRoute();
//		tickets.setArrival_city(getArrival_city());
//		tickets.setDeparture_city(getDeparture_city());
//		tickets.setDeparture_day(getDeparture_day());
//		tickets.setAirplane(getAir(getAirplane()));
//		tickets.setPrice(getPrice());
//	
//	  	userService.persistTicket(tickets);	
//
//  	return "sucess2";
//}
//}
