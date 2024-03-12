package com.ejada.demo.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.ValueChangeEvent;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import com.ejada.demo.entity.Airplane;
import com.ejada.demo.entity.UberRoute;
import com.ejada.demo.service.TicketService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name="crudView")
@SessionScoped
public class Admin_HP2_bean {


	private TicketService ticketService;
	

    private UberRoute ub;
    private UberRoute selectedTrip;
	
	private String departure_city;
	private Date departure_day;
	private String arrival_city;
	private int price;
	private String airplane; // airplane id = airplane name
	private int seats; 
	private String search_dep_city; 
	private String search_arrival_city; 
	private Date search_date; 
	List<UberRoute> allTickets;
	
	public List<UberRoute> getAllTickets() {
		return allTickets;
	}


	public void setAllTickets(List<UberRoute> allTickets) {
		this.allTickets = allTickets;
	}

	boolean userFlag=true;
	ResourceBundle resourceBundle;
	
	private List<String> countries=new ArrayList<String>();
	private Object selectedCountry;
	private List<Date> dates;
	
	public Admin_HP2_bean()  {
		//countries = new Object[]{	    "United States", "Canada", "Mexico"};
		this.ticketService =new TicketService();
		countries= getallAir();
		resourceBundle = ResourceBundle.getBundle("messages");
	}
	
	
	public void onDateSelect(SelectEvent<Date> event) {
		  // Get the selected date
	
		SimpleDateFormat format=new SimpleDateFormat("dd/MMM/yyyy");
		Date choosenDate=event.getObject();
		//System.out.println("PLANE:------>"+choosenDate);
		List<UberRoute>ticket=ticketService.getBookedAirplanes(format.format(choosenDate));
		System.out.println("PLANE:------>"+ticket.size());
//
		for(UberRoute s: ticket) {
    		System.out.println("PLANE:------>"+s.getAirplane().getAirplane_name());
    	}
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("DATE"+format.format(event.getObject())));
        System.out.println("HERE"+choosenDate.getDay()+"/"+choosenDate.getMonth()+"/"+choosenDate.getYear());
        if(ticket.size()!=0 ) {
        	List<String> ns = new ArrayList<String>();
        	for(String s: getallAir()) {
        		for(UberRoute r: ticket) {
	        		if(!s.equals(r.getAirplane().getAirplane_name())) {
	        			ns.add(s);
	        		}
        		}
        	}
        	
        	setCountries(ns);
        }else {
        	setCountries(getallAir());
        }
        
        //go to uerRoute and get airplane_id with that date if not null remove from dropdown the airplane 
        

		}
	
	
	public List<Date> getDates() {
		return dates;
	}


	public void setDates(List<Date> dates) {
		this.dates = dates;
	}


	public List<String> getCountries() {
		return countries;
	}


	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public Object getSelectedCountry() {
		return selectedCountry;
	}


	public void setSelectedCountry(Object selectedCountry) {
		this.selectedCountry = selectedCountry;
	}


	public boolean isUserFlag() {
		return userFlag;
	}


	public void setUserFlag(boolean userFlag) {
		this.userFlag = userFlag;
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
	
	
	public String getSearch_dep_city() {
		return search_dep_city;
	}


	public void setSearch_dep_city(String search_dep_city) {
		this.search_dep_city = search_dep_city;
	}


	public String getSearch_arrival_city() {
		return search_arrival_city;
	}

	public void setSearch_arrival_city(String search_arrival_city) {
		this.search_arrival_city = search_arrival_city;
	}


	public Date getSearch_date() {
		return search_date;
	}


	public void setSearch_date(Date search_date) {
		this.search_date = search_date;
	}


	public TicketService getUserService() {
		return ticketService;
	}

	public void setUserService(TicketService ticketService) {
		this.ticketService = ticketService;
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
	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	
	//--------------------------------------------------------



	public void openNew() {
		this.ub = new UberRoute();
	      //  this.selectedProduct = new Product();
	}
	public void addTicket() {
		 if (getSelectedTrip() == null) {
			System.out.println("airplane is :  "+getAirplane());
			System.out.println(" begin");
			System.out.println(getSelectedCountry().toString());
			try {
				UberRoute tickets = new UberRoute();
				tickets.setArrival_city(getArrival_city());
				tickets.setDeparture_city(getDeparture_city());
				tickets.setDeparture_day(getDeparture_day());
				tickets.setAirplane(getAir(getSelectedCountry().toString()));
				tickets.setPrice(getPrice());
				HttpSession session = (HttpSession) SessionUtils.getSession();
				ticketService.persistTicket(tickets,(String)(session.getAttribute("email")));
		        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Added"));
			}catch(Exception e) {
			//	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(getMessage(e.getMessage())));
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(resourceBundle.getString("fill_all_fields")));	 

			}
		 }else {
			 //edit
			try {
			UberRoute tickets = new UberRoute();
			tickets.setArrival_city(getArrival_city());
			tickets.setDeparture_city(getDeparture_city());
			tickets.setDeparture_day(getDeparture_day());
			tickets.setAirplane(getAir(getSelectedCountry().toString()));
			tickets.setPrice(getPrice());
		
			ticketService.updateTrip(getSelectedTrip(),tickets);	
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Updated"));
            setSelectedTrip(null);
			 }catch(Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(resourceBundle.getString("fill_all_fields")));	 

			 }
			setSelectedTrip(null);
			 
		 }
	   PrimeFaces.current().executeScript("PF('manageProductDialog').hide()");
       PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
      
	}
	
	public void editTicket() {
		System.out.println("EDDDDIIIIITTT");
		System.out.println(selectedTrip.getArrival_city());
		System.out.println(selectedTrip.getAirplane());
		System.out.println(selectedTrip.getDeparture_city());
		System.out.println(selectedTrip.getPrice());
		System.out.println(getPrice());

		UberRoute tickets = new UberRoute();
		tickets.setArrival_city(selectedTrip.getArrival_city());
		tickets.setDeparture_city(selectedTrip.getDeparture_city());
		tickets.setDeparture_day(selectedTrip.getDeparture_day());
		tickets.setAirplane(selectedTrip.getAirplane());
		tickets.setPrice(getPrice());
	
		ticketService.updateTrip(getSelectedTrip(),tickets);	
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Updated"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
       
	}
	
	public Airplane getAir(String airplane_id) {
		return 	ticketService.getAir(airplane_id);
	}
	public List<String> getallAir() {
		return 	ticketService.getallAir();
	}
	
	public List<UberRoute> getTickets() {
		System.out.println(" uber route bean");
		List<UberRoute> arr= ticketService.getTickets();
		setAllTickets(arr);
		return arr;
		
	}
	
    public void deleteProduct() {
    	//IF ALREADY NOT IN DATABASE THROW ERROR
    	System.out.println(getSelectedTrip().getArrival_city());
    	ticketService.deleteRoute(getSelectedTrip());
    	// delete from User_trip table as well
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Product Removed"));
        PrimeFaces.current().ajax().update("form:messages", "form:dt-products");
    }
    
	public String logOut() {
		HttpSession session = (HttpSession) SessionUtils.getSession();
		session.invalidate();
		return "login_page";
	}
    
    public void isUser(ComponentSystemEvent event){
		
		FacesContext fc = FacesContext.getCurrentInstance();
			
		if (!"admin".equals(fc.getExternalContext().getSessionMap().get("role"))){

			ConfigurableNavigationHandler nav 
			   = (ConfigurableNavigationHandler) 
				fc.getApplication().getNavigationHandler();
			
			nav.performNavigation("access-denied");
		}		
	 }
     
     
    
    
//    private String getMessage(String key, Object... args) {
//       ResourceBundle bundle = ResourceBundle.getBundle("messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());
//       String message = bundle.getString(key);
//       return MessageFormat.format(message, args);
//   }

	public void functionName() throws JRException, IOException{
		TicketService tc= new TicketService();

		InputStream template = FacesContext.getCurrentInstance().getExternalContext()
			                .getResourceAsStream("report1.jrxml"); 
		/* this function start reading from webapp so if you make another 
		folder inside webapp and put your xxxx.jrxml you should start path 
		with the name of folder but if you put your xxxx.jrxml in webapp directly 
		so you just can write xxxx.jrxml and this will be read from the function 
		- you can get xxxx.jrxml file from ireport project folders */


			        // Compile the report template
			        JasperReport jasperReport = JasperCompileManager.compileReport(template);

			        // Create a data source (e.g., a list of JavaBeans)
			        List<UberRoute> data = tc.getTickets();

			        // Fill the report with data
			        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRBeanCollectionDataSource(data));

			        // Export the report to PDF
			        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			        response.setContentType("application/pdf");
			        response.setHeader("Content-Disposition", "inline; filename=report.pdf");

			        try (OutputStream out = response.getOutputStream()) {
			            JasperExportManager.exportReportToPdfStream(jasperPrint, out);
			        

			        FacesContext.getCurrentInstance().responseComplete();
			}

	}
}
