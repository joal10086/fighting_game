package com.db.service.impl;


import java.util.ArrayList;

import com.db.dao.PersonalDao;
import com.db.model.Department;
import com.db.model.Personal;
import com.db.service.PersonalService;
import com.utils.Page;

public class PersonalServiceImpl extends UniversalServiceImpl implements PersonalService {
	private PersonalDao personalDao;
	@Override
	public Personal getPersonalByLoginname(String loginname, String flag) {
		return personalDao.getPersonalByLoginname(loginname, flag);
	}
	

	public PersonalDao getpersonalDao(){
		return this.personalDao;
	}
	
	public void setPersonalDao(PersonalDao personalDao){
		this.personalDao=personalDao;
	}


	@Override
	public Page getPersonal(String string, int pagenum, int pagesize, String p_text, String p_type) {
		ArrayList<Personal> list = personalDao.getInfor(string, pagenum, pagesize,p_text,p_type);
		int rows=personalDao.getInforCount(string);
		Page page=new Page(list,pagenum,rows,pagesize);
		return page;
	}


	@Override
	public Personal findPersonalById(int parseInt) {
		return personalDao.findPersonalById(parseInt);
	}


	@Override
	public ArrayList<Object> getDeptByPname(String loginname) {
		return personalDao.getDeptByPname(loginname);
	}
	

}
