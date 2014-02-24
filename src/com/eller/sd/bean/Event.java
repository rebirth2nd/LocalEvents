package com.eller.sd.bean;

import java.util.Date;

import com.eller.sd.adaptee.GoogleMapService;



public class Event implements Events{

String event_name;
String event_description;
int total_participants;
int registration_required;//0 for No, 1 for Yes
int event_type;//0 for public, 1 for private
String event_link;
Date event_startdate;
Date event_enddate;
String event_starttime;
String event_endtime;
String created_by;
String tags;
String location;
GoogleMapService adapter = new GoogleMapService();

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	try {
		this.location = adapter.addressValidation(location);
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
public String getTags() {
	return tags;
}
public void setTags(String tags) {
	this.tags = tags;
}
public String getEvent_starttime() {
	return event_starttime;
}
public void setEvent_starttime(String event_starttime) {
	this.event_starttime = event_starttime;
}
public String getEvent_endtime() {
	return event_endtime;
}
public void setEvent_endtime(String event_endtime) {
	this.event_endtime = event_endtime;
}
public String getEvent_name() {
	return event_name;
}
public void setEvent_name(String event_name) {
	this.event_name = event_name;
}
public String getEvent_description() {
	return event_description;
}
public void setEvent_description(String event_description) {
	this.event_description = event_description;
}
public int getTotal_participants() {
	return total_participants;
}
public void setTotal_participants(int total_participants) {
	this.total_participants = total_participants;
}
public int getRegistration_required() {
	return registration_required;
}
public void setRegistration_required(int registration_required) {
	this.registration_required = registration_required;
}
public int getEvent_type() {
	return event_type;
}
public void setEvent_type(int event_type) {
	this.event_type = event_type;
}
public String getEvent_link() {
	return event_link;
}
public void setEvent_link(String event_link) {
	this.event_link = event_link;
}
public Date getEvent_startdate() {
	return event_startdate;
}
public void setEvent_startdate(Date event_start_date) {
	this.event_startdate = event_start_date;
}
public Date getEvent_enddate() {
	return event_enddate;
}
public void setEvent_enddate(Date event_enddate) {
	this.event_enddate = event_enddate;
}

public String getCreated_by() {
	return created_by;
}
public void setCreated_by(String created_by) {
	this.created_by = created_by;
}


}
