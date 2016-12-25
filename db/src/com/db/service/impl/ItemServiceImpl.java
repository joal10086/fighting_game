package com.db.service.impl;

import java.util.ArrayList;

import com.db.dao.ItemDao;
import com.db.model.Department;
import com.db.model.Item;
import com.db.service.ItemService;
import com.utils.Page;

public class ItemServiceImpl extends UniversalServiceImpl implements ItemService {
	private ItemDao itemDao;
	@Override
	public Item getItemByItemname(String itemname, String flag) {
		return itemDao.getItemByItemname(itemname,flag);
	}
	
	public ItemDao getItemDao(){
		return this.itemDao;
	}
	
	public void setItemDao(ItemDao itemDao){
		this.itemDao= itemDao;
	}

	@Override
	public Page getItem(String string, int pagenum, int pagesize, String i_text, String i_type) {
		ArrayList<Item> list = itemDao.getInfor(string, pagenum, pagesize,i_text,i_type);
		int rows=itemDao.getInforCount(string);
		Page page=new Page(list,pagenum,rows,pagesize);
		return page;
	}




	@Override
	public Item findItemById(int parseInt) {
		return itemDao.findItemById(parseInt);
	}

	public Page getItemList(String string, int pagenum, int pagesize, String i_text, String i_type) {
		ArrayList<Item> list = itemDao.getInforList(string, pagenum, pagesize,i_text,i_type);
		int rows=itemDao.getInforCount(string);
		Page page=new Page(list,pagenum,rows,pagesize);
		return page;
	}

	@Override
	public String checkItemById(int parseInt) {
		return itemDao.checkItemById(parseInt);
	}
	

}
