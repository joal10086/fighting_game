package com.utils.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utils.IPSeeker;
import com.utils.PropertiesUtil;

@SuppressWarnings("serial")
public class CheckLoginFilter implements Filter {
	
	private IPSeeker ipseeker;
	private PropertiesUtil confpu;

	public void destroy() {
		System.out.println("ipfilter destroy");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		String loginname = (String)(session.getAttribute("loginname")==null?"":session.getAttribute("loginname"));

		try{
			if (loginname==null||"".equals(loginname)){
				String path = request.getRequestURI();
				if (path.contains("/customcenter/")){
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println("<html>"); 
					out.println("<script type=\"text/javascript\">"); 
					out.println("window.parent.location.href=\"index.shtml\";");
					out.write("</script>"); 
					out.println("</html>"); 
//					response.sendRedirect("index.shtml");
					return;
				}
			}
		}
		catch(Exception ex){
			
		}
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("ipfilter init");
	}

	// cross site scripting particular characher filter
	private boolean validateXSS(String value) {
		if (value.contains("<script")) {
			return true;
		} else if (value.contains("&lt;script")) {
			return true;
		} else if (value.contains("<")) {
			return true;
		} else if (value.contains("&lt;")) {
			return true;
		} else if (value.contains(">")) {
			return true;
		} else if (value.contains("&gt;")) {
			return true;
		} else if (value.contains("&#039")) {
			return true;
		} else if (value.contains("<div")) {
			return true;
		} else if (value.contains("&lt;div")) {
			return true;
		} else if (value.contains("<iframe")) {
			return true;
		} else if (value.contains("&lt;iframe")) {
			return true;
		} else if (value.contains("<img")) {
			return true;
		} else if (value.contains("&lt;img")) {
			return true;
		}
		return false;
	}
}
