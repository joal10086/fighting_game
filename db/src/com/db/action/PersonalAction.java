package com.db.action;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.db.action.BaseAction;
import com.db.service.PersonalService;
import com.db.model.Department;
import com.db.model.Personal;

public class PersonalAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4150935127018304033L;
	public static final Logger logger = Logger.getLogger(Personal.class);
	
	private PersonalService personalService;
	public void prepare() throws Exception {
		
	}
	
	// 处理用户请求的execute方法
	public String execute() throws Exception{
		return INPUT;
	}
	
	public String getPersonal()  throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		String loginname=request.getParameter("loginname")==null?"":request.getParameter("loginname").trim();
		ArrayList<Object>  data = personalService.getDeptByPname(loginname);
		
		String did,dname;
		if(data==null){
			request.setAttribute("message", "process failed!");
			return null;
		}else{
			did= data.get(0).toString();
			dname= data.get(1).toString();
		}
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append("<data>");
		xml.append("<did>" + did + "</did>");
		xml.append("<dname>" + dname + "</dname>");
		xml.append("</data>");
		response.getWriter().write(xml.toString());
		return null;
	}
	public String login(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		String loginname=request.getParameter("loginname")==null?"":request.getParameter("loginname").trim();
		String password=request.getParameter("password")==null?"":request.getParameter("password").trim();
		String captcha = request.getParameter("captcha") == null ? "" : request.getParameter("captcha");
		String sessionCaptcha = (String) session.getAttribute("captcha");
		
		if ("".equals(loginname)) {
			request.setAttribute("message", "please enter your account!");
			return "result";
		}
		if ("".equals(password)) {
			request.setAttribute("message", "please enter your password!");
			return "result";
		}
	 
		if (!captcha.equals(sessionCaptcha)) {
			request.setAttribute("message", "please enter verify code!");
			return "result";
		}
		
		Personal personal = personalService.getPersonalByLoginname(loginname,"");
		if (personal != null && password.equals(personal.getPassword())) {
			request.getSession().removeAttribute("loginname");
			
			request.getSession().setAttribute("loginname", personal.getLoginname());
			request.setAttribute("personal", personal);
			return "success";
		}else{
			request.setAttribute("message", "your account or password is incorrect!");
		}
		return "result";
		
	}
	
	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		String pid=request.getParameter("pid")==null?"":request.getParameter("pid").trim();
		
		if ("".equals(pid)){
			request.setAttribute("message", "Process failed!");
		}else{
			Personal personal = personalService.findPersonalById(Integer.parseInt(pid));
			if (personal==null){
				request.setAttribute("message", "can't find this object ");
				return "Personallist";
			}
			request.setAttribute("p", personal);
			request.setAttribute("modify", "1");
			return "addPersonal";
		}
		return "Personallist";
	}
	public String savePersonal(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		String loginname=request.getParameter("loginname")==null?"":request.getParameter("loginname").trim();
		String modify=request.getParameter("modify")==null?"":request.getParameter("modify").trim();
		
		String p_loginname=request.getParameter("p_loginname")==null?"":request.getParameter("p_loginname").trim();
		String p_password=request.getParameter("p_password")==null?"":request.getParameter("p_password").trim();
		
		String p_id=request.getParameter("p_id")==null?"":request.getParameter("p_id").trim();
		String p_f_name=request.getParameter("p_f_name")==null?"":request.getParameter("p_f_name").trim();
		String p_l_name=request.getParameter("p_l_name")==null?"":request.getParameter("p_l_name").trim();
		String gender=request.getParameter("gender")==null?"":request.getParameter("gender").trim();
		
		String p_dept_id=request.getParameter("p_dept_id")==null?"":request.getParameter("p_dept_id").trim();
		String p_role=request.getParameter("p_role")==null?"":request.getParameter("p_role").trim();
		String p_bd=request.getParameter("p_bd")==null?"":request.getParameter("p_bd").trim();
		String p_email=request.getParameter("p_email")==null?"":request.getParameter("p_email").trim();
		String p_phone=request.getParameter("p_phone")==null?"":request.getParameter("p_phone").trim();
		String captcha = request.getParameter("captcha") == null ? "" : request.getParameter("captcha");
		String sessionCaptcha = (String) session.getAttribute("captcha");
		
		if ("".equals(p_loginname)) {
			request.setAttribute("message", "Please input loginname!");
			return "addPersonal";
		}
		if ("".equals(p_password)) {
			request.setAttribute("message", "Please input password!");
			return "addPersonal";
		}
	 
		
		
		Personal personal = personalService.getPersonalByLoginname(loginname,"");
		Personal personalAdd = personalService.getPersonalByLoginname(p_loginname,"");
		
		if (personalAdd != null){
			if("1".equals(modify)){
				personalAdd.setLoginname(p_loginname);
				personalAdd.setPassword(p_password);
				personalAdd.setFirstname(p_f_name);
				personalAdd.setLastname(p_l_name);
				personalAdd.setGender(Byte.parseByte(gender));
				personalAdd.setDept_id(Integer.parseInt(p_dept_id));
				personalAdd.setRole(p_role);
				personalAdd.setEmail(p_email);
				personalAdd.setPhone(p_phone);
				
				if (!"".equals(p_bd)) {
					personalAdd.setBirthday(Timestamp.valueOf(p_bd + " 00:00:00.1"));
				}
			}else{
				request.setAttribute("message", "account has already existed!");
				return "addPersonal";
			}
		}else{
			personalAdd=new Personal();
			personalAdd.setLoginname(p_loginname);
			personalAdd.setPassword(p_password);
			personalAdd.setFirstname(p_f_name);
			personalAdd.setLastname(p_l_name);
			personalAdd.setGender(Byte.parseByte(gender));
			personalAdd.setDept_id(Integer.parseInt(p_dept_id));
			personalAdd.setRole(p_role);
			personalAdd.setEmail(p_email);
			personalAdd.setPhone(p_phone);
			personalAdd.setCreatetime(new java.sql.Timestamp(System.currentTimeMillis()));
			
			if (!"".equals(p_bd)) {
				personalAdd.setBirthday(Timestamp.valueOf(p_bd + " 00:00:00.1"));
			}
			personalService.saveOrUpdate(personalAdd);
		}
		
		return "Personallist";
	}
	
	public String mpdifyPersonalPW() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		
		String rt="modifyerror";
		String loginname=request.getParameter("loginname")==null?"":request.getParameter("loginname").trim();
		String password=request.getParameter("password")==null?"":request.getParameter("password").trim();
		String newpassword=request.getParameter("newpassword")==null?"":request.getParameter("newpassword").trim();
		String renewpassword=request.getParameter("renewpassword")==null?"":request.getParameter("renewpassword").trim();
		
		if ("".equals(loginname)) {
			request.setAttribute("message", "please enter your account!");
		}
		
		if ("".equals(password)) {
			request.setAttribute("message", "please enter your password!");
		}
		
		if (!renewpassword.equals(newpassword)) {
			request.setAttribute("message", "new password doesn't match!");
		}
		
		Personal personal = personalService.getPersonalByLoginname(loginname,"");
		
		if (personal != null){
			if(personal.getPassword().equals(password)){
				personal.setPassword(newpassword);
				personalService.saveOrUpdate(personal);
				
				request.getSession().removeAttribute("loginname");
				rt="modifysuccess";
			}else{
				request.setAttribute("message", "Password of this ccount isn't correct!");
			}
		}else{
			request.setAttribute("message", "this account doesn't exit!");
		}
		
		StringBuffer xml = new StringBuffer();
		xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xml.append("<amt>");
		xml.append("<loginname>" + loginname + "</loginname>");
		xml.append("<result>" + rt + "</result>");
		xml.append("</amt>");
		response.getWriter().write(xml.toString());
		
		return rt;
	}
	
	public String deletePersonal(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		String loginname=request.getParameter("loginname")==null?"":request.getParameter("loginname").trim();
		
		
		return null;
	}
	/*
	 * getPersonal by ID
	 */
	public String getPersonalById() throws IOException {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		
		String rstr="";
		String pid=request.getParameter("pid")==null?"":request.getParameter("pid").trim();
		Personal personal = personalService.findPersonalById(Integer.parseInt(pid));
		if (personal!=null){
			rstr= personal.getFirstname() + "  " + personal.getLastname();
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
	 * getList
	 */
	public String getList(){
	  	int pagenum=Integer.parseInt(this.getCurrentPage()==null?"1":this.getCurrentPage());
	    int pagesize=Integer.parseInt(this.getPageSize()==null?"20":this.getPageSize());
	    
	    HttpServletRequest request = ServletActionContext.getRequest();
	    
	    String p_text=request.getParameter("p_text")==null?"":request.getParameter("p_text").trim();
	    String p_type=request.getParameter("p_type")==null?"":request.getParameter("p_type").trim();
	    
	   
		page=personalService.getPersonal( "1", pagenum, pagesize,p_text,p_type);
		return "Personallist";
	}
	public String changeFlag(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String p_id=request.getParameter("updateId")==null?"":request.getParameter("updateId").trim();
		if("".equals(p_id)){
			request.setAttribute("message", "can't find this Personal   !");
			return "Personallist";
		}else{
			Personal p=personalService.findPersonalById(Integer.parseInt(p_id));
			if (p==null){
				request.setAttribute("message", "can't find this Personal!");
				return "Personallist";
			}else{
				p.setFlag(Byte.parseByte("0"));
				personalService.saveOrUpdate(p);
				return "addPersonal";
			}
		}
	}
	public PersonalService getPersonalService(){
		return personalService;
	}
	public void setPersonalService(PersonalService personalService){
		this.personalService=personalService;
	}
}
