package com.ejada.demo.bean;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ejada.demo.data_access.TicketDao;
import com.ejada.demo.entity.UberRoute;
import com.ejada.demo.service.TicketService;
import com.ejada.demo.service.UserService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean(name="login")
@SessionScoped
public class Login_bean {
	
	private String email; //unique and acts as username
	private String password;
	private UserService userService;
	
	boolean userFlag=false;
	
	String us="false";

	public Login_bean() {
		HttpSession session = (HttpSession) SessionUtils.getSession();
//		session.setAttribute("page", "none");
//		session.setAttribute("role", "none");

		this.userService = new UserService();
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
	
	public boolean isUserFlag() {
		return userFlag;
	}

	public void setUserFlag(boolean userFlag) {
		this.userFlag = userFlag;
	}

	
	
	public String getUs() {
		return us;
	}
	public void setUs(String us) {
		this.us = us;
	}
	public String checkuser() {
		HttpSession session = (HttpSession) SessionUtils.getSession();
		if(userService.checkuser(getEmail(),getPassword()).equals("user")  ) {
			session.setAttribute("email", getEmail());
			session.setAttribute("role", "user");
			setUserFlag(true);
			setUs("user");
		}else {
			if(userService.checkuser(getEmail(),getPassword()).equals("employee")) {
				session.setAttribute("email", getEmail());
				session.setAttribute("role", "admin");
				setUs("admin");
			}else {
			//System.out.println("NO USER OR ADMIN WITH THAT NAME -> SIGN IN");
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("NO USER OR ADMIN WITH THAT NAME -> SIGN IN"));
			}
     		//print error message
		}
		System.out.println( userService.checkuser(getEmail(),getPassword()));
		return userService.checkuser(getEmail(),getPassword());
		
	}
	

}
