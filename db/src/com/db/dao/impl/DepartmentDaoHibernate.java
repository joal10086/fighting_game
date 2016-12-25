package com.db.dao.impl;

import com.db.dao.DepartmentDao;
import com.db.dao.impl.UniversalDaoHibernate;
import com.db.model.Department;
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

public class DepartmentDaoHibernate extends UniversalDaoHibernate implements DepartmentDao {
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
	public Department findDeptById(int dept_id) {
		HibernateTemplate ht=this.getHibernateTemplate();
		ht.setMaxResults(1);
		List list=ht.find("from Department d where d.dept_id=? ", dept_id);
		
		ht.evict(list);
		if (list.size()>0){
			Department  d= (Department)list.get(0);
			ht.evict(d);
			return d;
		}
		else
			return null;
		
	}

	@Override
	public ArrayList<Department> getInfor(String flag, int pagenum, int pagesize,String dept_text, String dept_type) {
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria critera = session.createCriteria(Department.class);
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
		return (ArrayList<Department>) list;
	}

	@Override
	public int getDeptCount(String flag) {
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria critera = session.createCriteria(Department.class);
				if (!flag.equals("")) {
					critera.add(Restrictions.eq("flag", Byte.parseByte(flag)));
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
	public Department findDeptByName(String dept_name) {
		HibernateTemplate ht=this.getHibernateTemplate();
		ht.setMaxResults(1);
		List list=ht.find("from Department d where d.name=? ", dept_name);
		
		ht.evict(list);
		if (list.size()>0){
			Department  d= (Department)list.get(0);
			ht.evict(d);
			return d;
		}
		else
			return null;
	}





}
