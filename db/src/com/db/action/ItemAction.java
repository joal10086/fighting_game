package com.db.action;


import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.db.action.BaseAction;
import com.db.service.ItemService;
import com.db.service.PersonalService;
import com.db.model.Department;
import com.db.model.Item;
import com.db.model.Personal;

public class ItemAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4150935127018304033L;
	public static final Logger logger = Logger.getLogger(ItemAction.class);
	
	private ItemService itemService;
	public void prepare() throws Exception {
		
	}
	
	// 处理用户请求的execute方法
	public String execute() throws Exception{
		return INPUT;
	}
	
	/*
	 * getList
	 */
	public String getList(){
	  	int pagenum=Integer.parseInt(this.getCurrentPage()==null?"1":this.getCurrentPage());
	    int pagesize=Integer.parseInt(this.getPageSize()==null?"20":this.getPageSize());
	    
	    HttpServletRequest request = ServletActionContext.getRequest();
	    
	    String i_text=request.getParameter("i_text")==null?"":request.getParameter("i_text").trim();
	    String i_type=request.getParameter("i_type")==null?"":request.getParameter("i_type").trim();
	    
		page=itemService.getItem( "1", pagenum, pagesize,i_text,i_type);
		return "itemList";
	}
	
	//with department name in page
	public String getItemList(){
	  	int pagenum=Integer.parseInt(this.getCurrentPage()==null?"1":this.getCurrentPage());
	    int pagesize=Integer.parseInt(this.getPageSize()==null?"20":this.getPageSize());
	    
	    HttpServletRequest request = ServletActionContext.getRequest();
	    
	    String i_text=request.getParameter("i_text")==null?"":request.getParameter("i_text").trim();
	    String i_type=request.getParameter("i_type")==null?"":request.getParameter("i_type").trim();
	    
		page=itemService.getItemList( "1", pagenum, pagesize,i_text,i_type);
		return "itemList";
	}
	
	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		String item_mid=request.getParameter("i_mid")==null?"":request.getParameter("i_mid").trim();
		String item_id=request.getParameter("i_id")==null?"":request.getParameter("i_id").trim();
		String save=request.getParameter("save")==null?"":request.getParameter("save").trim();
		String item_name=request.getParameter("i_name")==null?"":request.getParameter("i_name").trim();
		String item_desp=request.getParameter("i_desp")==null?"":request.getParameter("i_desp").trim();
		String dept_id=request.getParameter("dept_id")==null?"":request.getParameter("dept_id").trim();
		String item_value=request.getParameter("i_value")==null?"":request.getParameter("i_value").trim();
		String item_qty=request.getParameter("i_qty")==null?"":request.getParameter("i_qty").trim();
		String item_maxday=request.getParameter("i_maxday")==null?"":request.getParameter("i_maxday").trim();
		String item_rate=request.getParameter("i_rate")==null?"":request.getParameter("i_rate").trim();
		 
		if (!"".equals(item_mid)) {
			
			Item i=itemService.findItemById(Integer.parseInt(item_mid));
			System.out.println("item_mid22222"+item_mid);
			if (i==null){
				request.setAttribute("message", "process failed!");
			}else{
				if("1".equals(save)){
					i.setFlag((byte) 1);
					i.setName(item_name);
					i.setDept_id(Integer.parseInt(dept_id));
					i.setDescription(item_desp);
					i.setValue(Integer.parseInt(item_value));
					i.setQty(Integer.parseInt(item_qty));
					i.setMaxday(Integer.parseInt(item_maxday));
					i.setCreatetime(new java.sql.Timestamp(System.currentTimeMillis()));
					itemService.saveOrUpdate(i);
				}
				
				request.setAttribute("i_mid", item_mid);
				request.getSession().setAttribute("i", i);
				request.setAttribute("message", "process succeed!");
			}
			return "addItem";
		}else {
			if ("".equals(item_name)){
				request.setAttribute("message", "please enter  name!");
				return "addItem";
			}
			if ("".equals(item_desp)){
				request.setAttribute("message", "please enter description!");
				return "addItem";
			}
			
			if ("".equals(item_value)){
				request.setAttribute("message", "please enter  value!");
				return "addItem";
			}
			if ("".equals(item_qty)){
				request.setAttribute("message", "please enter  quantity!");
				return "addItem";
			}
			
			Item d=itemService.getItemByItemname(item_name,"0");
			if (d==null){
				d= new Item();
				d.setFlag((byte) 1);
				d.setName(item_name);
				d.setDept_id(Integer.parseInt(dept_id));
				d.setDescription(item_desp);
				d.setValue(Integer.parseInt(item_value));
				d.setQty(Integer.parseInt(item_qty));
				d.setMaxday(Integer.parseInt(item_maxday));
				d.setCreatetime(new java.sql.Timestamp(System.currentTimeMillis()));
				itemService.saveOrUpdate(d);
			}else{
				request.setAttribute("message", "this record has already exited!");
				return "addItem";
			}
			
			
		} 
		return "itemList";
		
	}
	
	public String changeFlag(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String i_id=request.getParameter("updateId")==null?"":request.getParameter("updateId").trim();
		if("".equals(i_id)){
			request.setAttribute("message", "can't find this Item   !");
			return "result";
		}else{
			Item i=itemService.findItemById(Integer.parseInt(i_id));
			if (i==null){
				request.setAttribute("message", "can't find this Item!");
				return "result";
			}else{
				i.setFlag(Byte.parseByte("0"));
				itemService.saveOrUpdate(i);
				return "success";
			}
		}
	}
	/*
	 * check item by id
	 */
	public String checkItemById() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String rstr="";
		
		String iid=request.getParameter("iid")==null?"":request.getParameter("iid").trim();
		String item = itemService.checkItemById(Integer.parseInt(iid));
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
	
	/*
	 * getPersonal by ID
	 */
	public String getItemById() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String rstr="";
		String iid=request.getParameter("iid")==null?"":request.getParameter("iid").trim();
		Item item = itemService.findItemById(Integer.parseInt(iid));
		if (item!=null){
			rstr= item.getName();
		}
		
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append("<data>");
		xml.append("<rstr>" + rstr + "</rstr>");
		xml.append("</data>");
		response.getWriter().write(xml.toString());
		
		return null;
	}
	
	public boolean checkItem(String itemname, String flag) {
		boolean result = false;
		Item item = itemService.getItemByItemname(itemname, flag);
		if (item != null) {
			result = true;
		}
		return result;
	}

	public String aaa() {
		String returnStr = null;

		return returnStr;
	}
	
	public ItemService getItemService(){
		return itemService;
	}
	public void setItemService(ItemService itemService){
		this.itemService=itemService;
	}
}
