package com.db.service;

import java.io.Serializable;
import java.util.List;

public interface UniversalService {
	
	/**
	 * Generic interface for BASIC SAVE or UPDATE.
	 * 
	 * @param o - the Object to be persisted.
	 * @return Object - the persisted Object
	 */
	Object save(Object o);
	
	Object saveOrUpdate(Object o);

	/**
	 * Generic interface for BASIC single SELECT.
	 * 
	 * @param clazz - the Class that represents the database entity
	 * @param id - the primary key of the record to be retrieved
	 * @return Object - the record retrieved, OR NULL
	 */
	@SuppressWarnings("unchecked")
	Object get(Class clazz, Serializable id);
	
	/**
	 * Generic interface for BASIC single DROP.
	 * 
	 * @param clazz - the class that represents the database entity
	 * @param id - the primary key of the record to be deleted
	 */
	@SuppressWarnings("unchecked")
	void delete(Class clazz, Serializable id);
	
	/**
	 * Generic interface for BASIC SELECT * FROM .... statement 
	 * 
	 * @param clazz - the Class that represents the database entity.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	List loadAll(Class clazz);
	
	String getPno(String pno_prefix);
}