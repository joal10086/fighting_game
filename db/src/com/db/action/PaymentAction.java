package com.db.action;


import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.db.action.BaseAction;
import com.db.model.Payment;
import com.db.model.Personal;
import com.db.model.Use;
import com.db.service.ItemService;
import com.db.service.PaymentService;
import com.db.service.PersonalService;
import com.db.service.UseService;

public class PaymentAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4150935127018304033L;
	public static final Logger logger = Logger.getLogger(PaymentAction.class);
	
	private PersonalService personalService;
	private PaymentService  paymentService;
	private UseService  useService;
	
	public void prepare() throws Exception {
		
	}
	
	// 处理用户请求的execute方法
	public String execute() throws Exception{
		return INPUT;
	}
	
 
	
	public String add(){
		HttpServletRequest request= ServletActionContext.getRequest();
		String useid=request.getParameter("use_id")==null?"":request.getParameter("use_id").trim();
		String loginname=request.getParameter("loginname")==null?"":request.getParameter("loginname").trim();
		String amount=request.getParameter("amount")==null?"":request.getParameter("amount").trim();
		String remark=request.getParameter("remark")==null?"":request.getParameter("remark").trim();
		
		Use u = useService.findUseById(Integer.parseInt(useid));
		Personal p2 = personalService.getPersonalByLoginname(loginname, "");
		if (u!= null && p2!= null){
			Payment p = new Payment();
			p.setAmount(new BigDecimal(amount));
			p.setUse_id(u.getUse_id());
			p.setFlag(Byte.parseByte("1"));
			p.setCreatetime(new java.sql.Timestamp(System.currentTimeMillis()));
			p.setRemark(remark);
			
			paymentService.saveOrUpdate(p);
			request.setAttribute("message", "process successful");
		}else{
			request.setAttribute("message", "process failed");
		}
		return "paymentList";
	}
	public String approveClick(){
		HttpServletRequest request= ServletActionContext.getRequest();
		HttpServletResponse repond= ServletActionContext.getResponse();
		
		String payid = request.getParameter("useid") == null?"":request.getParameter("useid");
		String loginname= request.getParameter("loginname")==null?"":request.getParameter("loginname");
		
		Personal p = personalService.getPersonalByLoginname(loginname, "");
		
		if (p!=null){
			Payment pay = paymentService.getPaymentById(Integer.parseInt(payid),"");
			if (pay!=null){
				//set approved information pertaining with payment
				pay.setApproved_by(p.getEmp_id());
				pay.setPaytime(new java.sql.Timestamp(System.currentTimeMillis()));
				
				paymentService.saveOrUpdate(pay);
				
			}else{
				request.setAttribute("message", "process failed");
			}
			
		}else {
			request.setAttribute("message", "process failed");
		}
		return "paymentList";
		
		
	}
	public String getPaymentList(){
		int pagenum=Integer.parseInt(this.getCurrentPage()==null?"1":this.getCurrentPage());
	    int pagesize=Integer.parseInt(this.getPageSize()==null?"50":this.getPageSize());
	    
	    HttpServletRequest request = ServletActionContext.getRequest();
	    
	    String i_text=request.getParameter("pay_text")==null?"":request.getParameter("pay_text").trim();
	    String i_type=request.getParameter("pay_type")==null?"":request.getParameter("pay_type").trim();
	    
		page=paymentService.getPaymentList( "1", pagenum, pagesize,i_text,i_type);
		return "paymentList";
		
				
	}
	
	public PersonalService getPersonalService(){
		return personalService;
	}
	public void setPersonalService(PersonalService personalService){
		this.personalService=personalService;
	}
	
	public UseService getUseService(){
		return useService;
	}
	public void setUseService(UseService useService){
		this.useService=useService;
	}
	
	public PaymentService getPaymentService(){
		return paymentService;
	}
	public void setPaymentService(PaymentService paymentService){
		this.paymentService=paymentService;
	}
	
}
