package com.db.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trans")
@org.hibernate.annotations.Entity(dynamicUpdate=true,dynamicInsert=true,selectBeforeUpdate=true)
public class Use {

	public Use() {}	
	
	private Integer use_id;
	private Integer emp_id;
	private Integer item_id;
	private Timestamp creattime;
	private Timestamp deadline;	
	private Timestamp returntime;
	/*private Byte flag;*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "use_id", length = 11)
	public Integer getUse_id() {	return use_id;	}
	@Column(name = "emp_id", length = 11)
	public Integer getEmp_id() {	return emp_id;	}
	@Column(name = "item_id", length = 11)
	public Integer getItem_id() {	return item_id;	}
	@Column(name = "creattime")
	public Timestamp getCreattime() {	return creattime;	}
	@Column(name = "deadline")
	public Timestamp getDeadline() {	return deadline;	}
	@Column(name = "returntime")
	public Timestamp getReturntime() {	return returntime;	}
	/*@Column(name = "flag", length = 2)
	public Byte getFlag() {	return flag;	}*/
	
	public void setUse_id(Integer use_id) {		this.use_id = use_id;	}
	public void setEmp_id(Integer emp_id) {		this.emp_id = emp_id;	}
	public void setItem_id(Integer item_id) {		this.item_id = item_id;	}
	public void setCreattime(Timestamp creattime) {		this.creattime = creattime;	}
	public void setDeadline(Timestamp deadline) {		this.deadline = deadline;	}
	public void setReturntime(Timestamp returntime) {		this.returntime = returntime;	}
	/*public void setFlag(Byte flag) {		this.flag = flag;	}*/
}
