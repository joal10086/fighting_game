package com.db.service;

import com.db.model.Item;
import com.utils.Page;

public interface ItemService extends UniversalService  {

	Item getItemByItemname(String itemname, String flag);

	Page getItem(String string, int pagenum, int pagesize, String i_text, String i_type);

	Item findItemById(int parseInt);

	Page getItemList(String string, int pagenum, int pagesize, String i_text, String i_type);

	String checkItemById(int parseInt);


 
}
