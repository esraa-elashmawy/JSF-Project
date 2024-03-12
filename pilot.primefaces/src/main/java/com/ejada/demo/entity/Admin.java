package com.ejada.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.Session;

@NamedQuery(name="checkAdmin.byEmail.byPassword", query = "from Admin where email=:email and password=:pass")
@Entity
public class Admin {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int admin_id; // PK
    @Column(nullable = false)
	private String fname;
	private String lname;
	@Column(unique = true)
	private String email; //unique and acts as username
    @Column(nullable = false)
	private String password; 
	// all of above should not contain null 
	
	
	public int getAdmin_id() {
		return admin_id;
	}
	public Admin() {
		super();
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
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



	

}
