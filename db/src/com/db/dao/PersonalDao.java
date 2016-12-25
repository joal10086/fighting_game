package com.db.dao;

import java.util.ArrayList;

import com.db.model.Department;
import com.db.model.Personal;

public interface PersonalDao extends UniversalDao {

	Personal getPersonalByLoginname(String loginname, String flag);

	int getInforCount(String string);

	ArrayList<Personal> getInfor(String string, int pagenum, int pagesize, String p_text, String p_type);

	Personal findPersonalById(int parseInt);

	ArrayList<Object> getDeptByPname(String loginname);

 

}
