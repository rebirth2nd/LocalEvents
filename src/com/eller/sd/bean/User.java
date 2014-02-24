package com.eller.sd.bean;

import java.sql.Timestamp;

public class User implements Users {

	String uname;
	String upass;
	String organization;
	int user_type; //0 for normal user,1 for businesses and 2 for Administrators
	Timestamp user_created_date;
	Timestamp user_modified_date;
	int referred_id;
	String email_id;
	
	
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	public Timestamp getUser_created_date() {
		return user_created_date;
	}
	public void setUser_created_date(Timestamp user_created_date) {
		this.user_created_date = user_created_date;
	}
	public Timestamp getUser_modified_date() {
		return user_modified_date;
	}
	public void setUser_modified_date(Timestamp user_modified_date) {
		this.user_modified_date = user_modified_date;
	}
	public int getReferred_id() {
		return referred_id;
	}
	public void setReferred_id(int referred_id) {
		this.referred_id = referred_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	
	
}
