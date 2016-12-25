package com.db.dao;

import java.util.ArrayList;

import com.db.model.Department;
import com.db.model.Item;
import com.db.model.Use;

public interface ItemDao extends UniversalDao {

	Item findItemById(int parseInt);

	int getInforCount(String string);

	ArrayList<Item> getInfor(String string, int pagenum, int pagesize, String i_text, String i_type);
	ArrayList<Item> getInforList(String string, int pagenum, int pagesize, String i_text, String i_type);

	Item getItemByItemname(String itemname, String flag);

	String checkItemById(int parseInt);
 

}
