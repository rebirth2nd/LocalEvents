package com.eller.sd.bean;

import java.sql.Timestamp;

public interface Users {

	public int getUser_type();
	public void setUser_type(int user_type);
	public Timestamp getUser_created_date();
	public void setUser_created_date(Timestamp user_created_date);
	public Timestamp getUser_modified_date();
	public void setUser_modified_date(Timestamp user_modified_date);
	public int getReferred_id();
	public void setReferred_id(int referred_id);
	public String getEmail_id();
	public void setEmail_id(String email_id);
	public String getUname();
	public void setUname(String uname);
	public String getUpass();
	public void setUpass(String upass);
	public String getOrganization();
	public void setOrganization(String organization);
}
