package com.db.service;

import com.db.model.Use;
import com.utils.Page;

public interface UseService extends UniversalService  {

	Use findUseById(int parseInt);


	Page getUseList(String string, int pagenum, int pagesize, String use_text, String use_type);


	String checkItemById(int parseInt);
 
}
