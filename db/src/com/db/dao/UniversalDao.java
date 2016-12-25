package com.db.dao;

import java.io.Serializable;
import java.util.List;


public interface UniversalDao {

	/**
	 * Handles basic save OR update, 
	 * by passing the object/model to persisted
	 * 
	 * @param o - the object/model to be persisted
	 * @return Object - the persisted object/model
	 */
	Object save(Object o);
	
	Object saveOrUpdate(Object o) ;
	
	/**
	 * Handles basic retrieval of single record,
	 * by passing the <em>Class</em> that represents
	 * the database entity and the primary key (id) <em>Serializable</em>
	 * of the record to be retrieved.
	 * 
	 * @param clazz - the Class (model)
	 * @param id - the pk of the record to retrieve
	 * @return Object - returns the object in Class with pk, otherwise NULL
	 */
	@SuppressWarnings("unchecked")
	Object get(Class clazz, Serializable id);
	
	/**
	 * Handles basic single delete of records,
	 * by passing the <em>Class</em> the represents
	 * the database entity and the primary key (id) <em>Serializable</em>
	 * of the record to be retrieved.
	 * 
	 * @param clazz - the Class (model)
	 * @param id - the pk of the record to be deleted
	 */
	@SuppressWarnings("unchecked")
	void delete(Class clazz, Serializable id);
	
	/**
	 * Handles basic "SELECT * FROM ..." statement.
	 * 
	 * @param clazz - the Class (model)
	 * @return List - List of records in Class
	 */
	@SuppressWarnings("unchecked")
	List loadAll(Class clazz);

}
