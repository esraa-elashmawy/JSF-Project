package Authentiction;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ejada.demo.bean.SessionUtils;

@WebFilter(filterName = "AuthFilter", urlPatterns = { "*.xhtml" })
public class AuthorizationFilter implements Filter {

	public AuthorizationFilter() {
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {

			HttpServletRequest reqt = (HttpServletRequest) request;
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession ses = reqt.getSession(false);

			String reqURI = reqt.getRequestURI();
			if (reqURI.indexOf("/index.xhtml") >= 0
					|| (ses != null && ses.getAttribute("email") != null)
//					|| (ses != null && ses.getAttribute("role") != null && ses.getAttribute("role").equals("none") && ses.getAttribute("page") != null &&  ses.getAttribute("page").equals("none"))
//					|| (ses != null && ses.getAttribute("role") != null && ses.getAttribute("role").equals("user") && ses.getAttribute("page") != null && ses.getAttribute("page").equals("user"))
//					|| (ses != null && ses.getAttribute("role") != null && ses.getAttribute("role").equals("admin") && ses.getAttribute("page") != null && ses.getAttribute("page").equals("admin"))
					|| reqURI.contains("javax.faces.resource")
					|| reqURI.indexOf("/signuppg.xhtml") >= 0
					) {
				chain.doFilter(request, response);
			}else {
				resp.sendRedirect(reqt.getContextPath() + "/index.xhtml");
			}
	
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void destroy() {

	}
}