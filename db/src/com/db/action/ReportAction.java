package com.db.action;


import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.db.action.BaseAction;
import com.db.service.ItemService;
import com.db.service.PersonalService;
import com.db.service.ReportService;
import com.db.service.UseService;
import com.db.model.Item;
import com.db.model.Payment;
import com.db.model.Personal;
import com.db.model.Use;

public class ReportAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4150935127018304033L;
	public static final Logger logger = Logger.getLogger(ReportAction.class);
	
	private ReportService reportService;
	public void prepare() throws Exception {
		
	}
	
	// 处理用户请求的execute方法
	public String execute() throws Exception{
		return INPUT;
	}
	 
	
	

	public String aaa() {
		String returnStr = null;

		return returnStr;
	}
	
	public ReportService getReportService(){
		return reportService;
	}
	public void setReportService(ReportService reportService){
		this.reportService=reportService;
	}
	
	public String resourceAvailableList(){
		
		int pagenum=Integer.parseInt(this.getCurrentPage()==null?"1":this.getCurrentPage());
	    int pagesize=Integer.parseInt(this.getPageSize()==null?"50":this.getPageSize());
	    
	    HttpServletRequest request = ServletActionContext.getRequest();
	    
	    String i_text=request.getParameter("i_text")==null?"":request.getParameter("i_text").trim();
	    String i_type=request.getParameter("i_type")==null?"":request.getParameter("i_type").trim();
	    
		page=reportService.resourceAvailableList( "1", pagenum, pagesize,i_text,i_type);
		return "resourceAvailableList";
	}
	
	
	public String resourceWithPaymentList(){
		
		int pagenum=Integer.parseInt(this.getCurrentPage()==null?"1":this.getCurrentPage());
	    int pagesize=Integer.parseInt(this.getPageSize()==null?"50":this.getPageSize());
	    
	    HttpServletRequest request = ServletActionContext.getRequest();
	    
	    String i_text=request.getParameter("i_text")==null?"":request.getParameter("i_text").trim();
	    String i_type=request.getParameter("i_type")==null?"":request.getParameter("i_type").trim();
	    
		page=reportService.resourceWithPaymentList( "1", pagenum, pagesize,i_text,i_type);
		return "resourceWithPaymentList";
	}
	
}
