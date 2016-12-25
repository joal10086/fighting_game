package com.db.service.impl;

import java.util.ArrayList;

import com.db.dao.UseDao;
import com.db.model.Department;
import com.db.model.Use;
import com.db.service.UseService;
import com.utils.Page;

public class UseServiceImpl extends UniversalServiceImpl implements UseService {
	private UseDao useDao;
	
	
	public UseDao getUseDao(){
		return this.useDao;
	}
	
	public void setUseDao(UseDao useDao){
		this.useDao= useDao;
	}

	@Override
	public Use findUseById(int parseInt) {
		return useDao.findUseById(parseInt);
	}

	@Override
	public Page getUseList(String string, int pagenum, int pagesize, String use_text, String use_type) {
		ArrayList<Use> list = useDao.getInfor(string, pagenum, pagesize,use_text,use_type);
		int rows=useDao.getInforCount(string);
		Page page=new Page(list,pagenum,rows,pagesize);
		System.out.print("rows"+rows);
		return page;
	}

	@Override
	public String checkItemById(int parseInt) {
		return useDao.checkItemById(parseInt);
	}
}
