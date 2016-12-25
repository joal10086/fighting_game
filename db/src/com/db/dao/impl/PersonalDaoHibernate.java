package com.db.dao.impl;

import com.db.dao.PersonalDao;
import com.db.dao.impl.UniversalDaoHibernate;
import com.db.model.Department;
import com.db.model.Item;
import com.db.model.Personal;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class PersonalDaoHibernate extends UniversalDaoHibernate implements PersonalDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Personal getPersonalByLoginname(String loginname, String flag) {
		HibernateTemplate ht=this.getHibernateTemplate();
		ht.setMaxResults(1);
		List list=ht.find("from Personal p where p.loginname=? ", loginname);
		
		ht.evict(list);
		if (list.size()>0){
			Personal  p= (Personal)list.get(0);
			ht.evict(p);
			return p;
		}
		else
			return null;
	}

	@Override
	public int getInforCount(String string) {
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria critera = session.createCriteria(Personal.class);
				if (!string.equals("")) {
					critera.add(Restrictions.eq("flag", Byte.parseByte(string)));
				}
				ProjectionList plist = Projections.projectionList();
				plist.add(Projections.rowCount());
				critera.setProjection(plist);
				return critera.list();
			}
		});
		return ((Integer) list.get(0)).intValue();
	}

	@Override
	public ArrayList<Personal> getInfor(String flag, int pagenum, int pagesize, String text, String type) {
		ArrayList<Object> paramsList=new ArrayList<Object>();
		StringBuilder sql=new StringBuilder();
		sql.append("select * from personal as p, department as d  where p.dept_id= d.dept_id ");
		if (!flag.equals("")) {
			sql.append(" and p.flag=? ");
			paramsList.add(Byte.parseByte(flag));
		}
		if(type.equals("0")){
			if (!text.equals("")) {
				sql.append(" and p.pname=? ");
				paramsList.add( text);
			}
		}else{
			if (!text.equals("")) {
				sql.append(" and p.role=? ");
				paramsList.add(text);
			}
		}
		sql.append("limit ?,? ");
		paramsList.add((pagenum-1)*pagesize);
		paramsList.add(pagesize);
		
		Object[] params=paramsList.toArray();
		List list = this.getJdbcTemplate().queryForList(sql.toString(),params);
		return (ArrayList<Personal>)list;
		
		
		
		
		
		/*List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria critera = session.createCriteria(Personal.class);
				if (!string.equals("")) {
					critera.add(Restrictions.eq("flag", Byte.parseByte(string)));
				}
				if(p_type.equals("0")){
					if (!p_text.equals("")) {
						critera.add(Restrictions.eq("name", p_text));
					}
				}else{
					if (!p_text.equals("")) {
						critera.add(Restrictions.eq("role",p_text));
					}
				}
				
				critera.addOrder(Order.desc("id"));
				critera.setFirstResult((pagenum - 1) * pagesize);
				critera.setMaxResults(pagesize);
				return critera.list();
			}
		});
		return (ArrayList<Personal>) list;*/
	}

	@Override
	public Personal findPersonalById(int parseInt) {
		HibernateTemplate ht=this.getHibernateTemplate();
		ht.setMaxResults(1);
		List list=ht.find("from Personal p where p.emp_id=? ", parseInt);
		
		ht.evict(list);
		if (list.size()>0){
			Personal  p= (Personal)list.get(0);
			ht.evict(p);
			return p;
		}
		else
			return null;
	}

	@Override
	public ArrayList<Object> getDeptByPname(String loginname) {
		ArrayList<Object> arraydata=new ArrayList<Object>();
		ArrayList<Object> paramsList=new ArrayList<Object>();
		StringBuilder SQLSB=new StringBuilder();
		SQLSB.append("select d.dept_id as deptid, d.name as dname from  personal as p, department as d where d.dept_id = p.dept_id ");
		if (!"".equals(loginname)){
			SQLSB.append(" and loginname=? "); 
			paramsList.add(loginname);
		}
		Map data = this.getJdbcTemplate().queryForMap(SQLSB.toString(),paramsList.toArray());
		if (data.size()>0){
			arraydata.add(data.get("deptid").toString());
			arraydata.add(data.get("dname").toString());
		}else{
			return null;
		}
		
		return arraydata;
	}





}
