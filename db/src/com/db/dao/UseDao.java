package com.db.dao;

import java.util.ArrayList;

import com.db.model.Department;
import com.db.model.Use;

public interface UseDao extends UniversalDao {


	public ArrayList<Use> getInfor(String string, int pagenum, int pagesize, String use_text, String use_type);

	public int getInforCount(String string);

	public Use findUseById(int parseInt);

	public String checkItemById(int parseInt);

}
