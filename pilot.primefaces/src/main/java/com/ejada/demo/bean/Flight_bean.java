package com.ejada.demo.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ejada.demo.entity.Airplane;
import com.ejada.demo.service.UserService;

@ManagedBean(name="ticket")
@SessionScoped
public class Flight_bean {
	
//	private List<Tickets> allTickets;
//	private UserService userService;
//
//	
//	public List<Tickets> getAllTickets() {
//		return allTickets;
//	}
//
//	public void setAllTickets(List<Tickets> allFlights) {
//		this.allTickets = allFlights;
//	}
//	
//	public Flight_bean() {
//		this.userService =new UserService();
//		this.allTickets= getTickets();
//	}
//
//	public List<Tickets> getTickets() {
//		System.out.println(" bean");
//		List<Tickets> arr= userService.getTickets();
//		System.out.println("arr:"+arr.get(0).getArrival_city());
//		return arr;
//		
//	}
	
	public void book() {
		//get ticket id and add user_id to that ticket
		System.out.println(" BOOOK");
	}
}
