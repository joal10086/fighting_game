package com.db.action;


import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.db.action.BaseAction;
import com.db.service.ItemService;
import com.db.service.PersonalService;
import com.db.service.UseService;
import com.db.model.Item;
import com.db.model.Payment;
import com.db.model.Personal;
import com.db.model.Use;

public class TransAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4150935127018304033L;
	public static final Logger logger = Logger.getLogger(TransAction.class);
	
	private UseService useService;
	private PersonalService personalService;
	private ItemService itemService;
	public void prepare() throws Exception {
		
	}
	
	// 处理用户请求的execute方法
	public String execute() throws Exception{
		return INPUT;
	}
	/*
	 * add
	 */
 
	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		String trans_mid=request.getParameter("trans_mid")==null?"":request.getParameter("trans_mid").trim();
		String trans_id=request.getParameter("trans_id")==null?"":request.getParameter("trans_id").trim();
		String emp_id=request.getParameter("emp_id")==null?"":request.getParameter("emp_id").trim();
		String item_id=request.getParameter("item_id")==null?"":request.getParameter("item_id").trim();
		 
		if (!"".equals(trans_mid)) {
			Use u=useService.findUseById(Integer.parseInt(trans_mid));
			if (u==null){
				request.setAttribute("message", "process failed!");
			}else{
				u.setReturntime(new java.sql.Timestamp(System.currentTimeMillis()));
				useService.saveOrUpdate(u);
				
				long dayshould = u.getDeadline().getTime();
				long dayreal = System.currentTimeMillis();
				
				//update if there is a payment
				
				Item item = itemService.findItemById(u.getItem_id());
				int maxday= item.getMaxday();
				int itemvalue= item.getValue();
				
				double payamount=0;
				if (dayreal>dayshould){  //over time used 
					double overdat = (dayreal-dayshould)/86400000;
					System.out.println("day difference:" +overdat);
					if (overdat<1) {
						payamount=0;
					}else if (overdat>=1 && overdat<=maxday){
						double qution= overdat/maxday * itemvalue;
						payamount = Math.round(qution*100)/100.0;
					}else{
						payamount= itemvalue;
					}
					//overtime used, set a payment
					if (payamount>0){
						Payment p = new Payment();
						p.setAmount(new BigDecimal(payamount));
						p.setUse_id(u.getUse_id());
						p.setFlag(Byte.parseByte("1"));
						p.setCreatetime(new java.sql.Timestamp(System.currentTimeMillis()));
						p.setRemark("update by system");
						
						useService.saveOrUpdate(p);
					}
				}
			}
			return "transList";
		}
		if (!("".equals(emp_id) && "".equals(item_id))) {
			Item i = itemService.findItemById(Integer.parseInt(item_id));
			Personal p = personalService.findPersonalById(Integer.parseInt(item_id));
			if(i!=null && p!=null){
				
				long l=System.currentTimeMillis();
				
				Use  u = useService.findUseById(10000);
				u = new Use();
				u.setEmp_id(Integer.parseInt(emp_id));
				u.setItem_id(Integer.parseInt(item_id));
				u.setCreattime(new java.sql.Timestamp(l));
				
				int maxday=i.getMaxday();
				if (maxday>0){
					l =maxday * 86400000;
				} 
				 
				System.out.println("return time"+new java.sql.Timestamp(System.currentTimeMillis()+l));
				u.setDeadline(new java.sql.Timestamp(System.currentTimeMillis()+l));
				
				personalService.save(u);
			}
			return "transList";
		}else{
				request.setAttribute("message", "parameter is missing !");
				return "addTrans";
		}
		
	}
	
	/*
	 * getList
	 */
	public String getUseList(){
	  	int pagenum=Integer.parseInt(this.getCurrentPage()==null?"1":this.getCurrentPage());
	    int pagesize=Integer.parseInt(this.getPageSize()==null?"20":this.getPageSize());
	    
	    HttpServletRequest request = ServletActionContext.getRequest();
	    
	    String use_text=request.getParameter("use_text")==null?"":request.getParameter("use_text").trim();
	    String use_type=request.getParameter("use_type")==null?"":request.getParameter("use_type").trim();
	    
	   System.out.println("use_text>" +use_text+ ">use_type>"+use_type);
		page=useService.getUseList( "1", pagenum, pagesize,use_text,use_type);
		return "success";
	}
	
	public String checkTransId() throws Exception  {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String rstr="";
		
		String use_id=request.getParameter("use_id")==null?"":request.getParameter("use_id").trim();
		String item = useService.checkItemById(Integer.parseInt(use_id));
		if (item!=null){
			rstr= item;
		}
		
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append("<data>");
		xml.append("<rstr>" + rstr + "</rstr>");
		xml.append("</data>");
		response.getWriter().write(xml.toString());
		
		return null;
	}
	/*public String changeFlag(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String u_id=request.getParameter("updateId")==null?"":request.getParameter("updateId").trim();
		if("".equals(u_id)){
			request.setAttribute("message", "can't find this Transaction   !");
			return "result";
		}else{
			Use u=useService.findUseById(Integer.parseInt(u_id));
			if (u==null){
				request.setAttribute("message", "can't find this Transaction!");
				return "result";
			}else{
				u.setFlag(Byte.parseByte("0"));
				useService.saveOrUpdate(u);
				return "success";
			}
		}
	}*/
	
/*	public boolean checkItem(String itemname, String flag) {
		boolean result = false;
		Item item = itemService.getItemByItemname(itemname, flag);
		if (item != null) {
			result = true;
		}
		return result;
	}*/

	public String aaa() {
		String returnStr = null;

		return returnStr;
	}
	
	public UseService getUseService(){
		return useService;
	}
	public void setUseService(UseService useService){
		this.useService=useService;
	}
	
	public PersonalService getPersonalService(){
		return personalService;
	}
	public void setPersonalService(PersonalService personalService){
		this.personalService=personalService;
	}
	
	public ItemService getItemService(){
		return itemService;
	}
	public void setItemService(ItemService itemService){
		this.itemService=itemService;
	}
}
