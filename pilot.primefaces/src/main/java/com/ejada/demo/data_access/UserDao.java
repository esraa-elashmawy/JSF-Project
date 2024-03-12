package com.ejada.demo.data_access;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

import org.hibernate.Query;

import com.ejada.demo.entity.Admin;
import com.ejada.demo.entity.Airplane;
import com.ejada.demo.entity.Traveler_User;
import com.ejada.demo.entity.UberRoute;
import com.ejada.demo.entity.User_Trip;

public class UserDao {
	SessionFactory sessionFactory;
	
	public UserDao() {
		sessionFactory = Session_hib.getSessionFactory();
	}

	public void persistUser(Traveler_User user) {
			System.out.println("AT suser DOA before");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//sessionFactory.getCurrentSession().persist(user);
			session.save(user);
			session.getTransaction().commit();
			session.close();
			System.out.println("AT suser DOA");
		
	}

	public String checkuser(String email, String password) {
		System.out.println("check user dao");
		// TODO Auto-generated method stub
		String is="none";
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//sessionFactory.getCurrentSession().persist(user);
		//String emails=session.get(Traveler_User.class, email);
		Query query = session.getNamedQuery("checkUser.byEmail.byPassword");
		query.setString("email", email);
		query.setString("pass", password);
		List<Traveler_User> user =(List<Traveler_User>) query.list();
		System.out.println("user size: "+ user.size());
		if(user.size()!=0) {
			is="user";
		}
		Query queryAdmin = session.getNamedQuery("checkAdmin.byEmail.byPassword");
		queryAdmin.setString("email", email);
		queryAdmin.setString("pass", password);
		List<Admin> admin =(List<Admin>) queryAdmin.list();
		if(admin.size()!=0) {
			is="employee";
		}
		session.getTransaction().commit();
		session.close();
		return is;
	}

//	public Airplane getAir(String airplane_id) {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		Query queryPlane = session.getNamedQuery("getAirplane.byName");
//		queryPlane.setString("air", airplane_id);
//		List<Airplane> plane =(List<Airplane>) queryPlane.list();
//		session.getTransaction().commit();
//		session.close();
//		return plane.get(0);
//	}

//	public void persistTicket(UberRoute tickets) {
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.save(tickets);
//		session.getTransaction().commit();
//		session.close();
//		
//	}

//	public List<UberRoute> getTickets() {
//		List<UberRoute> allTickets = null;
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		Query query = session.getNamedQuery("UberRoute.getAll");
//		allTickets =(List<UberRoute>) query.list();
//		session.getTransaction().commit();
//		session.close();
//		System.out.println(allTickets.size());
//		return allTickets;
//	}
//
//	public void deleteRoute(UberRoute uberRoute) {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		session.delete(uberRoute);
//		session.getTransaction().commit();
//		session.close();
//	}
//
//	public void updateTrip(UberRoute selectedTrip, UberRoute tickets) {
//		// TODO Auto-generated method stub
//		Session session = sessionFactory.openSession();
//		session.beginTransaction();
//		UberRoute rs=(UberRoute)session.get(UberRoute.class,selectedTrip.getTicket_id());
//		System.out.println(selectedTrip.getTicket_id());
//		rs.setAirplane(tickets.getAirplane());
//		rs.setArrival_city(tickets.getArrival_city());
//		rs.setDeparture_city(tickets.getDeparture_city());
//		rs.setDeparture_day(tickets.getDeparture_day());
//		rs.setPrice(tickets.getPrice());
//		rs.setAirplane(tickets.getAirplane());
//		session.update(rs);
//		session.getTransaction().commit();
//		session.close();
//		
//	}

	public void bookTrip(UberRoute selectedTrip, String userEmail) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		System.out.println("BEFORE ");
		Query query = session.createQuery("from User_Trip where user_id=:email and trip_id=:trip");
		query.setInteger("email", getUserID(userEmail));
		query.setInteger("trip", selectedTrip.getTicket_id());

		List<User_Trip> User_Trips=(List<User_Trip>) query.list();

		//update User_Trip table with inc booked seats, user id and trip id
		if(User_Trips.size()==0) {
			User_Trip trip= new User_Trip();
			trip.setTrip_id(selectedTrip.getTicket_id());
			trip.setUser_id(getUserID(userEmail));
			trip.setNumber_of_assigned_seats(1);
			session.save(trip);
		}else {
			User_Trip trip=(User_Trip)session.get(User_Trip.class, User_Trips.get(0).getId());
			trip.setNumber_of_assigned_seats(trip.getNumber_of_assigned_seats()+1);
			session.update(trip);
		}
		// update ticket table by inc number of booked seats
		UberRoute route=(UberRoute)session.get(UberRoute.class, selectedTrip.getTicket_id());
		route.setBooked_seats(route.getBooked_seats()+1);
		session.update(route);
		
		
		
//		Query query = session.createSQLQuery("INSERT INTO uberroute_traveler_user VALUES (:ticketID,:userID)");
//		query.setInteger("ticketID", 25);
//		query.setInteger("userID", 21);
		//session.save(object)
		System.out.println("AFTER ");

		session.getTransaction().commit();
		System.out.println("AFTEEER ");

		session.close();
		
	}
	
	public int getUserID(String email) {
		int user;
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("from Traveler_User where email=:email ");
		query.setString("email", email);
		List<Traveler_User> rm=(List<Traveler_User>) query.list();
		user =rm.get(0).getUser_id();
		session.getTransaction().commit();
		session.close();
		System.out.println("USERID: "+ user);
		return user;
	}


}
