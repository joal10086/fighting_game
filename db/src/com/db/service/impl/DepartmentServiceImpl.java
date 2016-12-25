package com.db.service.impl;

import java.util.ArrayList;

import com.db.dao.DepartmentDao;
import com.db.model.Department;
import com.db.service.DepartmentService;
import com.utils.Page;

public class DepartmentServiceImpl extends UniversalServiceImpl implements DepartmentService {
	private DepartmentDao departmentDao;
	
	
	public DepartmentDao getDepartmentDao(){
		return this.departmentDao;
	}
	
	public void setDepartmentDao(DepartmentDao departmentDao){
		this.departmentDao= departmentDao;
	}

	public Department findDeptById(int dept_id) {
		return departmentDao.findDeptById(dept_id);
		
	}

	public Page getDept(String flag, int pagenum, int pagesize,String dept_text,String dept_type) {
		ArrayList<Department> list = departmentDao.getInfor(flag, pagenum, pagesize,dept_text,dept_type);
		int rows=departmentDao.getDeptCount(flag);
		Page page=new Page(list,pagenum,rows,pagesize);
		System.out.print("rows"+rows);
		return page;
	}

	@Override
	public Department findDeptByName(String dept_name) {
		return departmentDao.findDeptByName(dept_name);
	}
	
}
