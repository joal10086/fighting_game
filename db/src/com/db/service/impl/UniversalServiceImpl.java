package com.db.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import com.db.dao.UniversalDao;
import com.db.service.UniversalService;
import com.utils.DateUtil;
import com.utils.InitData;

public class UniversalServiceImpl implements UniversalService {
	
	private UniversalDao universalDao;
	private static final Object LOCKER=new Object();
	
	public void setUniversalDao(UniversalDao universalDao) {
		this.universalDao = universalDao;
	}

	/**
	 * Generic delete.
	 */
	@SuppressWarnings("unchecked")
	public void delete(Class clazz, Serializable id) {
		universalDao.delete(clazz, id);
	}

	/**
	 * Generic single select.
	 */
	@SuppressWarnings("unchecked")
	public Object get(Class clazz, Serializable id) {
		return universalDao.get(clazz, id);
	}

	/**
	 * Generic select all.
	 */
	@SuppressWarnings("unchecked")
	public List loadAll(Class clazz) {
		return universalDao.loadAll(clazz);
	}

	/**
	 * Generic save or update.
	 */
	public Object save(Object o) {
		return universalDao.save(o);
	}
	
	public Object saveOrUpdate(Object o) {
		return universalDao.saveOrUpdate(o);
	}
	
	public  String getPno(String pno_prefix){
		synchronized (LOCKER) {
			StringBuffer sb=new StringBuffer();
			sb.append(InitData.productcode);
			sb.append(pno_prefix);
			//日期时间
			sb.append(DateUtil.getDateFormat(new java.util.Date(),"yyMMddHHmmss"));
			//两位随机数
			Random ran2=new Random();
			int ranInt=ran2.nextInt(100);
			if (ranInt<10)
				ranInt+=10;
			sb.append(String.valueOf(ranInt));
			return sb.toString();
		}
	}	
}
