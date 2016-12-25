package com.db.dao.impl;

import com.db.dao.UseDao;
import com.db.dao.impl.UniversalDaoHibernate;
import com.db.model.Department;
import com.db.model.Item;
import com.db.model.Use;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class UseDaoHibernate extends UniversalDaoHibernate implements UseDao {
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
	/*@Override
	public Use getUserById(String id, String string) {
		ArrayList<Object> paramsList = new ArrayList<Object>();
		StringBuilder hql = new StringBuilder();
		hql.append("from User where ");
		if (!"".equals(id)) {
			hql.append(" id=? ");
			paramsList.add(id);
		}
		if (!("".equals(string) || string == null)) {
			hql.append(" and flag=? ");
			paramsList.add(string);
		}

		Object[] params = paramsList.toArray();
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.setMaxResults(1);
		List list = ht.find(hql.toString(), params);

		if (list.size() > 0) {
			Use use = (Use) list.get(0);
			ht.evict(use);
			return use;
		} else
			return null;
	}*/
	public Use getUserByU_name(String u_name, String flag) {
		ArrayList<Object> paramsList = new ArrayList<Object>();
		StringBuilder hql = new StringBuilder();
		hql.append("from User where ");
		if (!"".equals(u_name)) {
			hql.append(" u_name=? ");
			paramsList.add(u_name);
		}
		if (!("".equals(flag) || flag == null)) {
			hql.append(" and flag=? ");
			paramsList.add(flag);
		}

		Object[] params = paramsList.toArray();
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.setMaxResults(1);
		List list = ht.find(hql.toString(), params);

		if (list.size() > 0) {
			Use use = (Use) list.get(0);
			ht.evict(use);
			return use;
		} else
			return null;
	}

	//查询注册量
		public int getUserRegistCount(String startDate, String endDate, String flag){
			ArrayList<Object> paramsList=new ArrayList<Object>();
			StringBuilder SQLSB=new StringBuilder();
			System.out.println("start date:"+startDate+"endDate:"+endDate+"flag:"+flag);
			SQLSB.append("SELECT count(u_name) rows FROM User where ");
			
			if (!"".equals(startDate)){
				SQLSB.append(" create_time>=? "); 
				paramsList.add(startDate);
			}	
			if (!"".equals(endDate)){
				SQLSB.append(" and create_time<=? "); 
				paramsList.add(endDate);
			}
			if (!"".equals(flag)){
				SQLSB.append(" and flag=? "); 
				paramsList.add(flag);
			}
			System.out.println(SQLSB.toString());
			Map data = this.getJdbcTemplate().queryForMap(SQLSB.toString(),paramsList.toArray());
			int rows=Integer.parseInt(data.get("rows").toString());
			
			return rows;
		}
				
		
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public ArrayList<Use> getInfor(String flag, int pagenum, int pagesize, String use_text, String use_type) {
		ArrayList<Object> paramsList=new ArrayList<Object>();
		StringBuilder sql=new StringBuilder();
		sql.append("select d.dname as dname,p.firstname as pf , p.lastname as pl, i.`iname` as iname,u.use_id,u.creattime, u.deadline as udeadline ");
		sql.append(" from item as i, personal as p, trans as u , department as d   ");		 
		sql.append(" where d.dept_id = i.dept_id and p.emp_id = u.emp_id and i.item_id = u.item_id and (u.returntime IS NULL or u.returntime ='')  ");		 
				  
				 
		if (!flag.equals("")) {
			//sql.append(" and i.flag=? ");
			//paramsList.add(Byte.parseByte(flag));
		}
		if(use_type.equals("0")){
			if (!use_text.equals("")) {
				sql.append(" and p.firstname=? ");
				paramsList.add( use_text);
			}
		}else if (use_type.equals("1")){
			if (!use_text.equals("")) {
				sql.append(" and p.lastname=? ");
				paramsList.add(use_text);
			}
		}else{
			if (!use_text.equals("")) {
				sql.append(" and i.`iname`=? ");
				paramsList.add(use_text);
			}
		}
		sql.append("limit ?,? ");
		paramsList.add((pagenum-1)*pagesize);
		paramsList.add(pagesize);
		
		Object[] params=paramsList.toArray();
		List list = this.getJdbcTemplate().queryForList(sql.toString(),params);
		return (ArrayList<Use>)list;
	}
	@Override
	public int getInforCount(String string) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Use findUseById(int parseInt) {
		HibernateTemplate ht=this.getHibernateTemplate();
		ht.setMaxResults(1);
		List list=ht.find("from Use u where u.use_id=? ", parseInt);
		
		ht.evict(list);
		if (list.size()>0){
			Use  u= (Use)list.get(0);
			ht.evict(u);
			return u;
		}
		else
			return null;
	}

	@Override
	public String checkItemById(int parseInt) {
		ArrayList<Object> paramsList=new ArrayList<Object>();
		StringBuilder sql=new StringBuilder();
		sql.append("select  p.firstname as pf, p.lastname as pl, i.iname as iname  ");
		sql.append("  from item as i, personal as p, trans as t  " );
		sql.append("  where  t.emp_id = p.emp_id and t.item_id = i.item_id and t.use_id =?   ");	
		paramsList.add(parseInt);
				  
		try{
			Map data = this.getJdbcTemplate().queryForMap(sql.toString(),paramsList.toArray());
			if (data.size()>0){
				return data.get("pf").toString() +","+ data.get("pl").toString() +"  with  " +data.get("iname").toString();
			}else
				return null;
		}catch(Exception e){
			return null;
		}
	}





}
