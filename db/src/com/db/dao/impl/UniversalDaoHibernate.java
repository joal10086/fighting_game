package com.db.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.db.dao.UniversalDao;

public class UniversalDaoHibernate extends HibernateDaoSupport implements UniversalDao {

	/**
	 * Deletes record from clazz with id.
	 */
	@SuppressWarnings("unchecked")
	public void delete(Class clazz, Serializable id) {
		getHibernateTemplate().delete(get(clazz, id));
	}

	/**
	 * Retrieves data from clazz with id.
	 */
	@SuppressWarnings("unchecked")
	public Object get(Class clazz, Serializable id) {
		Object o = getHibernateTemplate().get(clazz, id);
		getHibernateTemplate().evict(o);
		return o;
	}

	/**
	 * Retrieves ALL records from clazz.
	 */
	@SuppressWarnings("unchecked")
	public List loadAll(Class clazz) {
		return getHibernateTemplate().loadAll(clazz);
	}

	/**
	 * Saves or updates record.
	 */
	public Object save(Object o) {
//		getHibernateTemplate().merge(o);
//		getHibernateTemplate().flush();
//		getHibernateTemplate().evict(o);
//		return o;
		return saveOrUpdate(o);
	}
	
	public Object saveOrUpdate(Object o) {
		getHibernateTemplate().saveOrUpdate(o);
//		getHibernateTemplate().flush();
//		getHibernateTemplate().evict(o);
		return o;
	}

}
