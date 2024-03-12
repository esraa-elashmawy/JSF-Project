package com.ejada.demo.service;

import java.util.List;

import com.ejada.demo.data_access.UserDao;
import com.ejada.demo.entity.Airplane;
import com.ejada.demo.entity.Traveler_User;
import com.ejada.demo.entity.UberRoute;

public class UserService {
	
	UserDao userDao;
	
	public UserService() {
		this.userDao=new UserDao();
	}
	
	public void persistUserS(Traveler_User user) {
		System.out.println("AT user service before ");
		userDao.persistUser(user);
		System.out.println("AT user service Finaalllllly");
		
	}

	public String checkuser(String email, String password) {
		System.out.println("check user service");
		return userDao.checkuser(email,password);
	
	}

//	public Airplane getAir(String airplane_id) {		
//		return userDao.getAir(airplane_id);
//		
//	}
//
////	public void persistTicket(UberRoute tickets) {
////		userDao.persistTicket(tickets);		
////	}
//
//	public List<UberRoute> getTickets() {
//		System.out.println(" service");
//		return userDao.getTickets();
//		
//	}
//
//	public void deleteRoute(UberRoute uberRoute) {
//		// TODO Auto-generated method stub
//		userDao.deleteRoute(uberRoute);
//	}
//
//	public void updateTrip(UberRoute selectedTrip, UberRoute tickets) {
//		// TODO Auto-generated method stub
//		userDao.updateTrip(selectedTrip,tickets);
//		
//	}

	public void bookTrip(UberRoute selectedTrip, String userEmail) {
		// TODO Auto-generated method stub
		userDao.bookTrip( selectedTrip,  userEmail);
		
	}

}
