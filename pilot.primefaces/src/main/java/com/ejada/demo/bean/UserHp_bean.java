package com.ejada.demo.bean;

import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.PrimeFaces;

import com.ejada.demo.entity.UberRoute;
import com.ejada.demo.service.TicketService;
import com.ejada.demo.service.UserService;

@ManagedBean(name="userView")
@SessionScoped
public class UserHp_bean {

	private UserService userService;
	private TicketService ticketService;
	private String userEmail;
	

    private UberRoute ub;
    private UberRoute selectedTrip;
	
	private String departure_city;
	private Date departure_day;
	private String arrival_city;
	private int price;
	private String airplane; // airplane id = airplane name
	//private int seats_booked;
	boolean adminFlag=true;
	boolean fullBooked=false;
	
	public UserHp_bean(){
		userService= new UserService();
		ticketService= new TicketService();
		HttpSession session = (HttpSession) SessionUtils.getSession();
//		session.setAttribute("page", "user");

		if(session.getAttribute("role").equals("admin")) {
			setAdminFlag(false);
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Unautherized to access requested page"));
		}
	}

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public UberRoute getUb() {
		return ub;
	}
	public void setUb(UberRoute ub) {
		this.ub = ub;
	}
	public UberRoute getSelectedTrip() {
		return selectedTrip;
	}
	public void setSelectedTrip(UberRoute selectedTrip) {
		this.selectedTrip = selectedTrip;
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
	public String getAirplane() {
		return airplane;
	}
	public void setAirplane(String airplane) {
		this.airplane = airplane;
	}
	
	public boolean isAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(boolean adminFlag) {
		this.adminFlag = adminFlag;
	}
	

//	public int getSeats_booked() {
//		return seats_booked;
//	}
//
//	public void setSeats_booked(int seats_booked) {
//		this.seats_booked = seats_booked;
//	}
//	

	public boolean isFullBooked() {
		return fullBooked;
	}

	public void setFullBooked(boolean fullBooked) {
		this.fullBooked = fullBooked;
	}

	public List<UberRoute> getTickets() {
		System.out.println(" uber route bean");
		List<UberRoute> arr= ticketService.getTickets();
		return arr;
		
	}
	public void bookTrip() {

    	if(getSelectedTrip().getAirplane().getNumber_of_seats() != getSelectedTrip().getBooked_seats()) {
	
		  	userService.bookTrip(getSelectedTrip(), getUserEmail());	
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Trip Booked"));
	        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
			
			System.out.println("BOOK THIS TRIP: "+ getUserEmail()+"   "+ getSelectedTrip().getDeparture_city()+"    "+getSelectedTrip().getArrival_city() );
    	}else {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Fully Booked"));
	        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
	        PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");

    	}
	}
	public String logOut() {
		HttpSession session = (HttpSession) SessionUtils.getSession();
		session.invalidate();
		return "login_page";
	}

}
