package com.db.dao.impl;

import com.db.dao.PaymentDao;
import com.db.dao.impl.UniversalDaoHibernate;
import com.db.model.Item;
import com.db.model.Payment;
import com.db.model.Personal;
import com.db.model.Use;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class PaymentDaoHibernate extends UniversalDaoHibernate implements PaymentDao {
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
	public Payment getPaymentById(int parseInt, String string) {
		HibernateTemplate ht = this.getHibernateTemplate();
		ht.setMaxResults(1);
		List list = ht.find("from Payment  where use_id=? ",parseInt);
		
		ht.evict(list);
		if (list.size()>0){
			Payment p= (Payment) list.get(0);
			ht.evict(p);
			return p;
		}else{
			return null;
		}
	}

	@Override
	public int getInforCount(String string) {
		List list = this.getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria critera = session.createCriteria(Payment.class);
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
	public ArrayList<Payment> getInforList(String flag, int pagenum, int pagesize, String use_text, String use_type) {
		ArrayList<Object> paramsList=new ArrayList<Object>();
		StringBuilder sql=new StringBuilder();
		sql.append("select pay.pay_id,p.firstname as pf , p.lastname as pl, i.iname, pay.remark as remark , pay.createtime as createtime ");
		sql.append(" from  item as i, personal as p, trans as u , payment  as pay    ");		 
		sql.append(" where pay.use_id = u.use_id and p.emp_id = u.emp_id  and i.item_id = u.item_id   and (pay.paytime is null or pay.paytime = '') ");		 
				  
		
		/*select p.firstname as pf , p.lastname as pl,i.`iname` as iname,pay.remark , pay.createtime
		from item as i, personal as p, trans as u , payment  as pay  
		where pay.use_id = u.use_id and p.emp_id = u.emp_id and i.item_id = u.item_id and u.returntime IS NULL 	
		*/
				 
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
				sql.append(" and d.dept_id=? ");
				paramsList.add(use_text);
			}
		}
		sql.append("limit ?,? ");
		paramsList.add((pagenum-1)*pagesize);
		paramsList.add(pagesize);
		
		Object[] params=paramsList.toArray();
		List list = this.getJdbcTemplate().queryForList(sql.toString(),params);
		return (ArrayList<Payment>)list;
	}





}
