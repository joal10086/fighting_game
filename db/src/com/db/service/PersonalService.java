package com.db.service;

import java.util.ArrayList;

import com.db.model.Personal;
import com.utils.Page;

public interface PersonalService extends UniversalService  {

	Personal getPersonalByLoginname(String loginname, String flag);

	Page getPersonal(String string, int pagenum, int pagesize, String p_text, String p_type);

	Personal findPersonalById(int parseInt);

	ArrayList<Object> getDeptByPname(String loginname);

 
}
