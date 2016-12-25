package com.db.service.impl;

import java.util.ArrayList;

import com.db.dao.ItemDao;
import com.db.dao.ReportDao;
import com.db.model.Department;
import com.db.model.Item;
import com.db.service.ItemService;
import com.db.service.ReportService;
import com.utils.Page;

public class ReportServiceImpl extends UniversalServiceImpl implements ReportService {
	private ReportDao reportDao;
	 
	 
	public ReportDao getReportDao(){
		return this.reportDao;
	}
	
	public void setReportDao(ReportDao reportDao){
		this.reportDao= reportDao;
	}

	@Override
	public Page resourceAvailableList(String string, int pagenum, int pagesize, String i_text, String i_type) {
		ArrayList<Item> list = reportDao.resourceAvailableList(string, pagenum, pagesize,i_text,i_type);
		int rows=reportDao.getResourceAvailableCount(string);
		Page page=new Page(list,pagenum,rows,pagesize);
		return page;
	}

	@Override
	public Page resourceWithPaymentList(String string, int pagenum, int pagesize, String i_text, String i_type) {
		ArrayList<Item> list = reportDao.resourceWithPaymentList(string, pagenum, pagesize,i_text,i_type);
		int rows=reportDao.getResourceAvailableCount(string);
		Page page=new Page(list,pagenum,rows,pagesize);
		return page;
	}

	 

}
