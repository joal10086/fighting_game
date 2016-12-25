package com.db.dao;

import java.util.ArrayList;

import com.db.model.Item;

public interface ReportDao extends UniversalDao {

	int getResourceAvailableCount(String string);

	ArrayList<Item> resourceAvailableList(String string, int pagenum, int pagesize, String i_text, String i_type);

	ArrayList<Item> resourceWithPaymentList(String string, int pagenum, int pagesize, String i_text, String i_type);

	 
 

}
