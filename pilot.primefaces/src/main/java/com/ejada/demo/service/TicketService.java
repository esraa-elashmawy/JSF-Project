package com.ejada.demo.service;

import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.ejada.demo.data_access.TicketDao;
import com.ejada.demo.entity.Airplane;
import com.ejada.demo.entity.UberRoute;

public class TicketService {
	
	TicketDao  ticketDao;
	
	public TicketService() {
		this.ticketDao= new TicketDao();
	}

	public void persistTicket(UberRoute tickets,String email) {


		//VALIDATE on the input tickets
		System.out.println(tickets.getDeparture_city());
		System.out.println(tickets.getArrival_city());
		System.out.println(tickets.getDeparture_day());
		System.out.println(tickets.getAirplane());
		
		if(tickets.getDeparture_city() == null || tickets.getArrival_city() == null || tickets.getDeparture_day() == null
				|| tickets.getPrice() == 0 || tickets.getAirplane() == null) {
	        throw new IllegalArgumentException();
		}

		ticketDao.persistTicket(tickets, email);

		
		
	}
	
	public Airplane getAir(String airplane_id) {	
		
		return ticketDao.getAir(airplane_id);
		
	}


	public List<UberRoute> getTickets() {
		System.out.println(" service");
		return ticketDao.getTickets();
		
	}

	public void deleteRoute(UberRoute uberRoute) {
		// TODO Auto-generated method stub
		ticketDao.deleteRoute(uberRoute);
	}

	public void updateTrip(UberRoute selectedTrip, UberRoute tickets) {
		// TODO Auto-generated method stub
		if(tickets.getDeparture_city() == null || tickets.getArrival_city() == null || tickets.getDeparture_day() == null
				|| tickets.getPrice() == 0 || tickets.getAirplane() == null) {
	        throw new IllegalArgumentException();
		}
		
		ticketDao.updateTrip(selectedTrip,tickets);
		
	}

	public List<String> getallAir() {
		// TODO Auto-generated method stub
		return ticketDao.getallAir();
	}

	public List<UberRoute> getBookedAirplanes(String string) {
		return ticketDao.getBookedAirplanes( string);
		// TODO Auto-generated method stub
		
	}
}
