package com.nishant.springboot.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="USER_DETAILS")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE,generator="gen")
	@TableGenerator(name="gen",table="ID_GEN",pkColumnName="ID_GEN_KEY",pkColumnValue="ID_GEN_VALUE",allocationSize=1)
	@Column(name="USER_ID")
	private int userid;
	@NotNull
	@Column(name="USER_NAME")
	private String username;
	@NotNull
	@Column(name="USER_COMPANY_NAME")
	private String usercompanyname;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsercompanyname() {
		return usercompanyname;
	}
	public void setUsercompanyname(String usercompanyname) {
		this.usercompanyname = usercompanyname;
	}
	
	

}
