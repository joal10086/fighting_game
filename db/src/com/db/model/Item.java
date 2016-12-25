package com.db.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
@org.hibernate.annotations.Entity(dynamicUpdate=true,dynamicInsert=true,selectBeforeUpdate=true)
public class Item {

	public Item() {}	
	
	private Integer item_id;
	private Byte flag;
	private Integer dept_id;
	private String name;
	private String description;	
	private Integer value;	
	private Integer qty;	
	private Integer maxday;	
/*	private BigDecimal payrate;	*/
	private Timestamp createtime;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id", length = 11)
	public Integer getItem_id() {	return item_id;	}
	@Column(name = "flag", length = 2)
	public Byte getFlag() {	return flag;	}
	@Column(name = "dept_id", length = 11)
	public Integer getDept_id() {	return dept_id;	}
	@Column(name = "iname", length = 20)
	public String getName() {	return name;	}
	@Column(name = "description", length = 200)
	public String getDescription() {	return description;	}
	@Column(name = "value", length = 5)
	public Integer getValue() {	return value;	}
	@Column(name = "qty")
	public Integer getQty() {	return qty;	}
	@Column(name = "maxday", length = 2)
	public Integer getMaxday() {	return maxday;	}
	/*@Column(name = "payrate")
	public BigDecimal getPayrate() {	return payrate;	}*/
	@Column(name = "createtime", length = 10)
	public Timestamp getCreatetime() {	return createtime;	}
	
	public void setItem_id(Integer item_id) {		this.item_id = item_id;	}
	public void setFlag(Byte flag) {		this.flag = flag;	}
	public void setDept_id(Integer dept_id) {		this.dept_id = dept_id;	}
	public void setName(String name) {		this.name = name;	}
	public void setDescription(String description) {		this.description = description;	}
	public void setValue(Integer value) {		this.value = value;	}
	public void setQty(Integer qty) {		this.qty = qty;	}
	public void setMaxday(Integer maxday) {		this.maxday = maxday;	}
	/*public void setPayrate(BigDecimal payrate) {		this.payrate = payrate;	}*/
	public void setCreatetime(Timestamp createtime) {		this.createtime = createtime;	}
}
