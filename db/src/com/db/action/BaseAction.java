package com.db.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.utils.Constant;
import com.utils.NetworkUtil;
import com.utils.Page;

@SuppressWarnings({"serial"})
public abstract class BaseAction extends ActionSupport implements Preparable {
	public static final Logger logger = Logger.getLogger(BaseAction.class);
	
	protected Md5PasswordEncoder passwordEncoder;	
	
	protected String systemMessage;
	protected String currentPage;
	protected String pageSize;
	protected String startDate;
	protected String endDate;
	protected Page page;

	public BaseAction() {
		Constant.PROJECTPATH=this.getProjectPath();
	}

	public void prepare() throws Exception {		
	}		

	protected String getSessionLoginname(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String loginname=request.getSession().getAttribute("loginname")==null?"":(String)request.getSession().getAttribute("loginname");
		return loginname;
	}
	
	protected String getIp(){
		HttpServletRequest request=ServletActionContext.getRequest();
        String ip="";
		try {
			ip = NetworkUtil.getIpAddress(request);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        return ip; 
	}	
	
	protected String getProjectPath(){
		HttpServletRequest request=ServletActionContext.getRequest();
		return request.getSession().getServletContext().getRealPath("/");
	}
	
	public Md5PasswordEncoder getPasswordEncoder() {
		return passwordEncoder;
	}

	public void setPasswordEncoder(Md5PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}	

	public String getSystemMessage() {
		return systemMessage;
	}

	public void setSystemMessage(String systemMessage) {
		this.systemMessage = getText(systemMessage);
	}


	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public String getPageSize() {
		return pageSize;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

}
