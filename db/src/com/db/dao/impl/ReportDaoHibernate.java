package com.db.dao.impl;

import com.db.dao.ItemDao;
import com.db.dao.ReportDao;
import com.db.model.Department;
import com.db.model.Item;
import com.db.model.Payment;
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

public class ReportDaoHibernate extends UniversalDaoHibernate implements ReportDao {
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
	public int getResourceAvailableCount(String string) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Item> resourceAvailableList(String flag, int pagenum, int pagesize, String i_text,
			String i_type) {
		ArrayList<Object> paramsList=new ArrayList<Object>();
		StringBuilder sql=new StringBuilder();
		sql.append("select  i.item_id,i.iname,i.description,d.dname,count(*) as ctr, (i.qty -  count(*)) as dif, i.createtime,i.qty from item as i, department d, trans as t   ");
		sql.append("  where   i.dept_id = d.dept_id and i.item_id = t.item_id  and t.returntime is null  " );
		sql.append("    GROUP BY i.item_id    ");	
		sql.append("   having i.qty > ctr  ");	
	 
		
		Object[] params=paramsList.toArray();
		List list = this.getJdbcTemplate().queryForList(sql.toString(),params);
		return (ArrayList<Item>)list;
		 
	}

	@Override
	public ArrayList<Item> resourceWithPaymentList(String string, int pagenum, int pagesize, String i_text,
			String i_type) {
		ArrayList<Object> paramsList=new ArrayList<Object>();
		StringBuilder sql=new StringBuilder();
		sql.append("select pay.pay_id,p.firstname as pf , p.lastname as pl, d.dname as dname, pay.remark as remark , pay.createtime as createtime ");
		sql.append(" from  department as d, personal as p, trans as u , payment  as pay    ");		 
		sql.append(" where pay.use_id = u.use_id and p.emp_id = u.emp_id and d.dept_id = p.dept_id  and pay.paytime is not null   ");		 
				  
		
		/*select p.firstname as pf , p.lastname as pl,i.`iname` as iname,pay.remark , pay.createtime
		from item as i, personal as p, trans as u , payment  as pay  
		where pay.use_id = u.use_id and p.emp_id = u.emp_id and i.item_id = u.item_id and u.returntime IS NULL 	
		*/
				 
		if (!string.equals("")) {
			//sql.append(" and i.flag=? ");
			//paramsList.add(Byte.parseByte(flag));
		}
		if(i_type.equals("0")){
			if (!i_text.equals("")) {
				sql.append(" and p.firstname=? ");
				paramsList.add( i_text);
			}
		}else if (i_type.equals("1")){
			if (!i_text.equals("")) {
				sql.append(" and p.lastname=? ");
				paramsList.add(i_text);
			}
		}else{
			if (!i_text.equals("")) {
				sql.append(" and d.dept_id=? ");
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



}
