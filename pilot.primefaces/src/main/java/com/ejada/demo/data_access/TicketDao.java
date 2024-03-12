package com.ejada.demo.data_access;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ejada.demo.entity.Admin;
import com.ejada.demo.entity.Airplane;
import com.ejada.demo.entity.Traveler_User;
import com.ejada.demo.entity.UberRoute;
import com.ejada.demo.entity.User_Trip;

public class TicketDao {
	SessionFactory sessionFactory;

	public TicketDao() {
		sessionFactory = Session_hib.getSessionFactory();
	}
	
	public void persistTicket(UberRoute tickets, String email) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Admin where email=:email ");
		query.setString("email", email);
		List<Admin> rm=(List<Admin>) query.list();
		Admin hr =rm.get(0);
		tickets.setAdmin(hr);
		//get admin using email and set it to ticket
		session.save(tickets);
		
		Airplane air=tickets.getAirplane();
		Date date=tickets.getDeparture_day();
		// disable admin from picking the same airplane for the same day 
		
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	public List<UberRoute> getTickets() {
		List<UberRoute> allTickets = null;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.getNamedQuery("UberRoute.getAll");
		allTickets =(List<UberRoute>) query.list();
		session.getTransaction().commit();
		session.close();
		System.out.println(allTickets.size());
		return allTickets;
	}

	public void deleteRoute(UberRoute uberRoute) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(uberRoute);
		// delete from USER_Trip
		Query query = session.createQuery("from User_Trip where trip_id=:id ");
		query.setInteger("id",uberRoute.getTicket_id());
		List<User_Trip> trip=(List<User_Trip>) query.list();
		for(User_Trip ut: trip) {
			session.delete(ut);
		}
		session.getTransaction().commit();
		session.close();
	}

	public void updateTrip(UberRoute selectedTrip, UberRoute tickets) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		UberRoute rs=(UberRoute)session.get(UberRoute.class,selectedTrip.getTicket_id());
		System.out.println(selectedTrip.getTicket_id());
		rs.setAirplane(tickets.getAirplane());
		rs.setArrival_city(tickets.getArrival_city());
		rs.setDeparture_city(tickets.getDeparture_city());
		rs.setDeparture_day(tickets.getDeparture_day());
		rs.setPrice(tickets.getPrice());
		rs.setAirplane(tickets.getAirplane());
		session.update(rs);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public Airplane getAir(String airplane_id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query queryPlane = session.getNamedQuery("getAirplane.byName");
		queryPlane.setString("air", airplane_id);
		List<Airplane> plane =(List<Airplane>) queryPlane.list();
		session.getTransaction().commit();
		session.close();
		return plane.get(0);
	}

	public List<String> getallAir() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select airplane_name from Airplane ");
		List<String> air=(List<String>) query.list();
	
		session.getTransaction().commit();
		session.close();
		return air;
	}

	public List<UberRoute> getBookedAirplanes(String string) {
		// TODO Auto-generated method stub
		// get airplanes with the chosendate
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery(" from UberRoute where TRUNC(departure_day)=:ddate ");
		query.setString("ddate", string);
		List<UberRoute> air=(List<UberRoute>) query.list();
		session.getTransaction().commit();
		session.close();
		return air;
	}
	

}
