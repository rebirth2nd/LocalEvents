package com.eller.sd.bean;

import java.util.Date;

public interface Events {

	public String getTags();
	public void setTags(String tags);
	public String getEvent_starttime();
	public void setEvent_starttime(String event_starttime);
	public String getEvent_endtime();
	public void setEvent_endtime(String event_endtime);
	public String getEvent_name();
	public void setEvent_name(String event_name);
	public String getEvent_description();
	public void setEvent_description(String event_description);
	public int getTotal_participants();
	public void setTotal_participants(int total_participants);
	public int getRegistration_required();
	public void setRegistration_required(int registration_required);
	public int getEvent_type();
	public void setEvent_type(int event_type);
	public String getEvent_link();
	public void setEvent_link(String event_link);
	public Date getEvent_startdate();
	public void setEvent_startdate(Date event_start_date);
	public Date getEvent_enddate();
	public void setEvent_enddate(Date event_enddate);
	public String getCreated_by();
	public void setCreated_by(String created_by);


}
