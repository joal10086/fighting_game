package com.db.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
@org.hibernate.annotations.Entity(dynamicUpdate=true,dynamicInsert=true,selectBeforeUpdate=true)
public class Department {

	public Department() {}	
	
	private Integer dept_id;
	private Byte flag;
	private String name;
	private String location;
	private Timestamp createtime;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dept_id", length = 11)
	public Integer getDept_id() {	return dept_id;	}
	@Column(name = "flag", length = 2)
	public Byte getFlag() {	return flag;	}
	@Column(name = "dname", length = 20)
	public String getName() {	return name;	}
	@Column(name = "location", length = 11)
	public String getLocation() {	return location;	}
	@Column(name = "createtime")
	public Timestamp getCreatetime() {	return createtime;	}
	
	public void setDept_id(Integer dept_id) {		this.dept_id = dept_id;	}
	public void setFlag(Byte flag) {		this.flag = flag;	}
	public void setCreatetime(Timestamp createtime) {		this.createtime = createtime;	}
	public void setName(String name) {		this.name = name;	}
	public void setLocation(String location) {		this.location = location;	}
}
