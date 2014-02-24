package com.eller.sd.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.eller.sd.bean.Event;
import com.eller.sd.database.DBConnection;

public class EventExtractor {

	
	public ArrayList<Event> retrieveEvents()
	{
		DBConnection dbconnection = DBConnection.getDBConnection();
		Connection conn = dbconnection.getConn();
		
		ArrayList<Event> events = new ArrayList<Event>();
		
		
		String events_query = "Select event_name,event_description,total_participants,registration_required,event_type,event_link,event_startdate,event_enddate,event_starthour,event_endhour,created_by,location from events where date(event_startdate)>= current_date order by event_startdate LIMIT 10";
		
		try {
			PreparedStatement extract = conn.prepareStatement(events_query);
			
			ResultSet rs = extract.executeQuery();
			
			while(rs.next())
			{
				Event event = new Event();
				
				event.setEvent_name(rs.getString(1));
				event.setEvent_description(rs.getString(2));
				event.setTotal_participants(rs.getInt(3));
				event.setRegistration_required(rs.getInt(4));
				event.setEvent_type(rs.getInt(5));
				event.setEvent_link(rs.getString(6));
				event.setEvent_startdate(rs.getDate(7));
				event.setEvent_enddate(rs.getDate(8));
				event.setEvent_starttime(rs.getString(9));
				event.setEvent_endtime(rs.getString(10));
				event.setCreated_by(rs.getString(11));
				event.setLocation(rs.getString(12));
				event.setTags(gettags(rs.getString(1)));
				
				events.add(event);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return events;
		
	}
	
	
	private String gettags(String eventname) {

		String tags = "select distinct cat_name from event_categories where event_name = '"+eventname+"'";
		String final_tags="";
		try {
			ResultSet rs = DBConnection.getDBConnection().getConn().createStatement().executeQuery(tags);
			while(rs.next())
			{
				final_tags+=rs.getString(1)+",";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return final_tags.replaceAll("$,", "");
	}


	public ArrayList<String> registeredEvents(ArrayList<String> events,String username)
	{
		DBConnection dbconnection = DBConnection.getDBConnection();
		Connection conn = dbconnection.getConn();
		
		String events_query = "Select event_id from interested where user_id = ?";
		System.out.println(events_query);
		
		try {
			PreparedStatement extract = conn.prepareStatement(events_query);
			extract.setString(1, username);
			
			ResultSet rs = extract.executeQuery();
			
			while(rs.next())
			{
				String event = rs.getString(1);
				
				events.add(event);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return events;
		
	}
}
