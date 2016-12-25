package com.db.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.db.action.BaseAction;
import com.db.service.DepartmentService;
import com.db.model.Department;

public class DepartmentAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4150935127018304033L;
	public static final Logger logger = Logger.getLogger(DepartmentAction.class);
	
	private DepartmentService departmentService;
	public void prepare() throws Exception {
		
	}
	
	// 处理用户请求的execute方法
	public String execute() throws Exception{
		return INPUT;
	}
	
	public String add(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		String dept_mid=request.getParameter("dept_mid")==null?"":request.getParameter("dept_mid").trim();
		String dept_id=request.getParameter("dept_id")==null?"":request.getParameter("dept_id").trim();
		String dept_name=request.getParameter("dept_name")==null?"":request.getParameter("dept_name").trim();
		String dept_addr=request.getParameter("dept_addr")==null?"":request.getParameter("dept_addr").trim();
		 
		if (!"".equals(dept_mid)) {
			Department d=departmentService.findDeptById(Integer.parseInt(dept_mid));
			if (d==null){
				request.setAttribute("message", "process failed!");
			}else{
				request.setAttribute("dept_mid", dept_mid);
				request.getSession().setAttribute("dept_id", d.getDept_id());
				request.getSession().setAttribute("dept_name", d.getName());
				request.getSession().setAttribute("dept_addr", d.getLocation());
			}
			return "result";
		}
		if ("".equals(dept_id)) {
			if ("".equals(dept_name)){
				request.setAttribute("message", "please enter department name!");
				return "result";
			}
			if ("".equals(dept_addr)){
				request.setAttribute("message", "please enter department address!");
				return "result";
			}
			
			Department d=departmentService.findDeptByName(dept_name);
			if (d==null){
				d= new Department();
				d.setFlag((byte) 1);
				d.setName(dept_name);
				d.setLocation(dept_addr);
				d.setCreatetime(new java.sql.Timestamp(System.currentTimeMillis()));
				departmentService.saveOrUpdate(d);
			}else{
				request.setAttribute("message", "this record has already exited!");
				return "result";
			}
			
			
		}else{
			Department d=departmentService.findDeptById(Integer.parseInt(dept_id));
			if (d==null){
				request.setAttribute("message", "please enter your account!");
				return "result";
			}else{
				d.setName(dept_name);
				d.setLocation(dept_addr);
				departmentService.saveOrUpdate(d);
			}
			
		}
		return "success";
		
	}
	
	/*
	 * getList
	 */
	public String getList(){
	  	int pagenum=Integer.parseInt(this.getCurrentPage()==null?"1":this.getCurrentPage());
	    int pagesize=Integer.parseInt(this.getPageSize()==null?"20":this.getPageSize());
	    
	    HttpServletRequest request = ServletActionContext.getRequest();
	    
	    String dept_text=request.getParameter("dept_text")==null?"":request.getParameter("dept_text").trim();
	    String dept_type=request.getParameter("dept_type")==null?"":request.getParameter("dept_type").trim();
	    
	   
		page=departmentService.getDept( "1", pagenum, pagesize,dept_text,dept_type);
		return "success";
	}
	public String changeFlag(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String dept_id=request.getParameter("updateId")==null?"":request.getParameter("updateId").trim();
		if("".equals(dept_id)){
			request.setAttribute("message", "can't find this department   !");
			return "result";
		}else{
			Department d=departmentService.findDeptById(Integer.parseInt(dept_id));
			if (d==null){
				request.setAttribute("message", "can't find this department!");
				return "result";
			}else{
				d.setFlag(Byte.parseByte("0"));
				departmentService.saveOrUpdate(d);
				return "success";
			}
		}
	}
	
	/*public String delete(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String dept_id=request.getParameter("dept_id")==null?"":request.getParameter("dept_id").trim();
		if("".equals(dept_id)){
			request.setAttribute("message", "can't find this department !");
			return "result";
		}else{
			Department d=departmentService.findDeptById(dept_id);
			if (d==null){
				request.setAttribute("message", "can't find this department!");
				return "result";
			}else{
				d.setFlag(Byte.parseByte("0"));
				return "success";
			}
		}
	}*/
	
	public DepartmentService getDepartmentService(){
		return departmentService;
	}
	public void setDepartmentService(DepartmentService departmentService){
		this.departmentService=departmentService;
	}
	
}
