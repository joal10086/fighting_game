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
@Table(name = "payment")
@org.hibernate.annotations.Entity(dynamicUpdate=true,dynamicInsert=true,selectBeforeUpdate=true)
public class Payment {

	public Payment() {}	
	
	private Integer pay_id;
	private Integer use_id;
	private Byte flag;
	private Integer approved_by;
	private BigDecimal amount;
	private Timestamp paytime;
	private Timestamp createtime;
	private String remark;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pay_id", length = 11)
	public Integer getPay_id() {	return pay_id;	}
	@Column(name = "use_id", length = 11)
	public Integer getUse_id() {	return use_id;	}
	@Column(name = "flag", length = 2)
	public Byte getFlag() {	return flag;	}
	@Column(name = "approved_by", length = 11)
	public Integer getApproved_by() {	return approved_by;	}
	@Column(name = "amount", length = 10)
	public BigDecimal getAmount() {	return amount;	}
	@Column(name = "remark", length = 100)
	public String getRemark() {	return remark;	}
	@Column(name = "paytime")
	public Timestamp getPaytime() {	return paytime;	}
	@Column(name = "createtime")
	public Timestamp getCreatetime() {	return createtime;	}
	
	public void setPay_id(Integer pay_id) {		this.pay_id = pay_id;	}
	public void setUse_id(Integer use_id) {		this.use_id = use_id;	}
	public void setFlag(Byte flag) {		this.flag = flag;	}
	public void setApproved_by(Integer approved_by) {		this.approved_by = approved_by;	}
	public void setAmount(BigDecimal amount) {		this.amount = amount;	}
	public void setPaytime(Timestamp paytime) {		this.paytime = paytime;	}
	public void setCreatetime(Timestamp createtime) {		this.createtime = createtime;	}
	public void setRemark(String remark) {		this.remark = remark;	}
	
}
