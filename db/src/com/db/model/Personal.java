package com.db.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "personal")
@org.hibernate.annotations.Entity(dynamicUpdate=true,dynamicInsert=true,selectBeforeUpdate=true)
public class Personal {

	public Personal() {}	
	
	private Integer emp_id;
	private Byte flag;
	private Byte gender;
	private Integer dept_id;
	private String loginname;
	private String password;
	private String firstname;	
	private String lastname;	
	private String role;	
	private Timestamp birthday;	
	private String email;	
	private String phone;	
	private Timestamp createtime;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id", length = 11)
	public Integer getEmp_id() {	return emp_id;	}
	@Column(name = "flag", length = 2)
	public Byte getFlag() {	return flag;	}
	@Column(name = "gender", length = 2)
	public Byte getGender() {	return gender;	}
	@Column(name = "dept_id", length = 11)
	public Integer getDept_id() {	return dept_id;	}
	@Column(name = "loginname", length = 10)
	public String getLoginname() {	return loginname;	}
	@Column(name = "password", length = 10)
	public String getPassword() {	return password;	}
	@Column(name = "firstname", length = 10)
	public String getFirstname() {	return firstname;	}
	@Column(name = "lastname", length = 10)
	public String getLastname() {	return lastname;	}
	@Column(name = "role", length = 20)
	public String getRole() {	return role;	}
	@Column(name = "birthday")
	public Timestamp getBirthday() {	return birthday;	}
	 
	@Column(name = "email", length = 20)
	public String getEmail() {	return email;	}
	@Column(name = "phone", length = 20)
	public String getPhone() {	return phone;	}
	@Column(name = "createtime")
	public Timestamp getCreatetime() {	return createtime;	}
	
	public void setEmp_id(Integer emp_id) {		this.emp_id = emp_id;	}
	public void setFlag(Byte flag) {		this.flag = flag;	}
	public void setGender(Byte gender) {		this.gender = gender;	}
	public void setDept_id(Integer dept_id) {		this.dept_id = dept_id;	}
	public void setLoginname(String loginname) {		this.loginname = loginname;	}
	public void setPassword(String password) {		this.password = password;	}
	public void setFirstname(String firstname) {		this.firstname = firstname;	}
	public void setLastname(String lastname) {		this.lastname = lastname;	}
	public void setRole(String role) {		this.role = role;	}
	public void setBirthday(Timestamp birthday) {		this.birthday = birthday;	}
	 
	public void setEmail(String email) {		this.email = email;	}
	public void setPhone(String phone) {		this.phone = phone;	}
	public void setCreatetime(Timestamp createtime) {		this.createtime = createtime;	}
	
	
	
	
	
	
	
	
	
}
