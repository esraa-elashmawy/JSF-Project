package com.ejada.demo.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@NamedQuery(name="checkUser.byEmail.byPassword", query = "from Traveler_User where email=:email and password=:pass")
@Entity
public class Traveler_User {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int user_id; // PK
    @Column(nullable = false)
	private String fname;
	private String lname;
	@Column(unique = true, nullable = false)
	private String email; //unique and acts as username
    @Column(nullable = false)
	private String password;
	

	//@OneToMany(mappedBy="user")
	//private Collection<Tickets> tickets = new ArrayList<Tickets>();
//	@ManyToMany(mappedBy="user")
//	private Collection<UberRoute> tickets = new ArrayList<UberRoute>();
	
	public Traveler_User() {
		
	}

	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
