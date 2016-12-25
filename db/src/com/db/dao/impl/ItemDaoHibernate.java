package com.db.dao.impl;

import com.db.dao.ItemDao;
import com.db.model.Department;
import com.db.model.Item;
import com.db.dao.impl.UniversalDaoHibernate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class ItemDaoHibernate extends UniversalDaoHibernate implements ItemDao {
	private JdbcTemplate jdbcTemplate;

	/*
	 * public boolean getUserByU_name(String u_name, String maybe) { boolean r =
	 * false; ArrayList<Object> paramsList = new ArrayList<Object>();
	 * StringBuilder SQLSB = new StringBuilder(); SQLSB.append(
	 * "SELECT count(u_name) rows FROM customers "); if (!"".equals(u_name)){
	 * SQLSB.append(" and u_name=? "); paramsList.add(u_name); } Map data =
	 * this.getJdbcTemplate().queryForMap(SQLSB.toString(),
	 * paramsList.toArray()); int rows =
	 * Integer.parseInt(data.get("rows").toString()); if (rows > 0) { r = true;
	 * } return r;
	 * 
	 * }
	 */
	
		
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Item findItemById(int parseInt) {
		HibernateTemplate ht=this.getHibernateTemplate();
		ht.setMaxResults(1);
		List list=ht.find("from Item i where i.item_id=? ", parseInt);
		
		ht.evict(list);
		if (list.size()>0){
			Item  o= (Item)list.get(0);
			ht.evict(o);
			return o;
		}
		else
			return null;
	}

	@Override
	public int getInforCount(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Item> getInfor(String flag, int pagenum, int pagesize,String dept_text, String dept_type) {
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria critera = session.createCriteria(Item.class);
				if (!flag.equals("")) {
					critera.add(Restrictions.eq("flag", Byte.parseByte(flag)));
				}
				if(dept_type.equals("0")){
					if (!dept_text.equals("")) {
						critera.add(Restrictions.eq("name", dept_text));
					}
				}else{
					if (!dept_text.equals("")) {
						critera.add(Restrictions.eq("location",dept_text));
					}
				}
				
				critera.addOrder(Order.desc("id"));
				critera.setFirstResult((pagenum - 1) * pagesize);
				critera.setMaxResults(pagesize);
				return critera.list();
			}
		});
		return (ArrayList<Item>) list;
	}
	
	@Override
	public ArrayList<Item> getInforList(String flag, int pagenum, int pagesize, String i_text, String i_type) {
		ArrayList<Object> paramsList=new ArrayList<Object>();
		StringBuilder sql=new StringBuilder();
		sql.append("select * from item as i, department as d  where i.dept_id= d.dept_id ");
		if (!flag.equals("")) {
			sql.append(" and i.flag=? ");
			paramsList.add(Byte.parseByte(flag));
		}
		if(i_type.equals("0")){
			if (!i_text.equals("")) {
				sql.append(" and i.iname=? ");
				paramsList.add( i_text);
			}
		}else{
			if (!i_text.equals("")) {
				sql.append(" and d.dname=? ");
				paramsList.add(i_text);
			}
		}
		sql.append("limit ?,? ");
		paramsList.add((pagenum-1)*pagesize);
		paramsList.add(pagesize);
		
		Object[] params=paramsList.toArray();
		List list = this.getJdbcTemplate().queryForList(sql.toString(),params);
		return (ArrayList<Item>)list;
		 
	}

	@Override
	public Item getItemByItemname(String itemname, String flag) {
		HibernateTemplate ht=this.getHibernateTemplate();
		ht.setMaxResults(1);
		List list=ht.find("from Item i where i.name=? ", itemname);
		
		ht.evict(list);
		if (list.size()>0){
			Item  o= (Item)list.get(0);
			ht.evict(o);
			return o;
		}
		else
			return null;
	}

	@Override
	public String checkItemById(int parseInt) {
		ArrayList<Object> paramsList=new ArrayList<Object>();
		StringBuilder sql=new StringBuilder();
		sql.append("select  iname from Item   ");
		sql.append("  where  qty > (select count(trans.item_id) from trans where trans.returntime IS NULL and  trans.item_id=? " );
		paramsList.add(parseInt);
		sql.append("  )and item_id =?  ");	
		paramsList.add(parseInt);
				  
		try{
			Map data = this.getJdbcTemplate().queryForMap(sql.toString(),paramsList.toArray());
			if (data.size()>0){
				return data.get("iname").toString();
			}else
				return null;
		}catch(Exception e){
			return null;
		}
	}



}
