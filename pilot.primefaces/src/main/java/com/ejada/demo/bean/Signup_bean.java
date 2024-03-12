package com.ejada.demo.bean;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ejada.demo.entity.Traveler_User;
import com.ejada.demo.service.UserService;

@ManagedBean(name="signupBean")
@SessionScoped
public class Signup_bean {
	
	private UserService userService;

	private String fname;
	private String lname;
	private String email; //unique and acts as username
	private String password;
	private Traveler_User user = new Traveler_User();
	
	public Signup_bean() {
		this.userService =new UserService();
		System.out.print("HEREEEEEEEEEEEEEEEEEEE");
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String adduser() {
		System.out.println("ADDDDD UUUUUSEEEERRRRRR");
		
		return "h";
	}
	
	
	public String signup() {
		System.out.println(getFname());

		System.out.println("AT signup bean begin");
		Traveler_User user = new Traveler_User();
		user.setFname(getFname());
		user.setLname(getLname());
		user.setEmail(getEmail());
		user.setPassword(getPassword());
		
		System.out.println(user);
		System.out.println(user.getFname());
		System.out.println(user.getLname());
		System.out.println(user.getEmail());
		System.out.println(user.getPassword());
		System.out.println("AT signup bean2");
		if(user == null) {
			System.out.println("IT IS NULL");
		}else {
			System.out.println("not null");
		}
//		this.userService = new UserService();

		userService.persistUserS(user);	
		System.out.println("AT signup bean3");
		return "success";
	}

	public Traveler_User getUser() {
		return user;
	}

	public void setUser(Traveler_User user) {
		this.user = user;
	}
	
	
	

}
