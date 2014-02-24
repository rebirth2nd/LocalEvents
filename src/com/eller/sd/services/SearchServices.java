package com.eller.sd.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.eller.sd.bean.Event;
import com.eller.sd.database.DBConnection;

public class SearchServices {

	//Search by event tag
	public ArrayList<Event> searchByTag(String tag)
	{
		ArrayList<Event> events = new ArrayList<Event>();
		
		String query ="Select e.event_name,e.event_description, e.event_startdate, e.event_enddate, e.event_starthour, e.event_endhour, e.created_by, e.location from events e "+
					  " where e.event_name in (select distinct event_name from event_categories where lower(cat_name)=lower(?))";
		
		System.out.println(query);
		
		PreparedStatement statement;
		try {
			DBConnection dbconnection = DBConnection.getDBConnection();
			Connection conn = dbconnection.getConn();
			
			statement = conn.prepareStatement(query);		
			statement.setString(1, tag);
		
			ResultSet rs = statement.executeQuery();
		
			while(rs.next())
			{
				Event event = new Event();
				
				event.setEvent_name(rs.getString(1));
				event.setEvent_description(rs.getString(2));
				event.setEvent_startdate(rs.getDate(3));
				event.setEvent_enddate(rs.getDate(4));
				event.setEvent_starttime(rs.getString(5));
				event.setEvent_endtime(rs.getString(6));
				event.setCreated_by(rs.getString(7));
				event.setLocation(rs.getString(8));

				events.add(event);
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return events;
	}
	//Search by title
	public ArrayList<Event> searchByTitle(String title)
	{
		ArrayList<Event> events = new ArrayList<Event>();
		
		String query ="Select e.event_name,e.event_description, e.event_startdate, e.event_enddate, e.event_starthour, e.event_endhour, e.created_by, e.location from events e "+
					  " where e.event_name like ?";
		
		System.out.println(query);
		
		PreparedStatement statement;
		try {
			DBConnection dbconnection = DBConnection.getDBConnection();
			Connection conn = dbconnection.getConn();
			
			statement = conn.prepareStatement(query);
			statement.setString(1, "%"+title+"%");
		
			ResultSet rs = statement.executeQuery();
		
			while(rs.next())
			{
				Event event = new Event();
				
				event.setEvent_name(rs.getString(1));
				event.setEvent_description(rs.getString(2));
				event.setEvent_startdate(rs.getDate(3));
				event.setEvent_enddate(rs.getDate(4));
				event.setEvent_starttime(rs.getString(5));
				event.setEvent_endtime(rs.getString(6));
				event.setCreated_by(rs.getString(7));
				event.setLocation(rs.getString(8));

				events.add(event);
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return events;
	}
	
	//Search by dates
	public ArrayList<Event> searchByDate(String Start_date,String End_date)
	{
		ArrayList<Event> events = new ArrayList<Event>();
		
		String query ="Select e.event_name,e.event_description, e.event_startdate, e.event_enddate, e.event_starthour, e.event_endhour, e.created_by, e.location from events e "+
					  " where date(e.event_startdate) >= ?" +
					  "and date(e.event_enddate) <= ? order by e.event_startdate";
		
		System.out.println(query);
		
		PreparedStatement statement;
		try {
			DBConnection dbconnection = DBConnection.getDBConnection();
			Connection conn = dbconnection.getConn();
			
			statement = conn.prepareStatement(query);
			statement.setString(1, Start_date);
			statement.setString(2, End_date);
			
		
			ResultSet rs = statement.executeQuery();
		
			while(rs.next())
			{
				Event event = new Event();
				
				event.setEvent_name(rs.getString(1));
				event.setEvent_description(rs.getString(2));
				event.setEvent_startdate(rs.getDate(3));
				event.setEvent_enddate(rs.getDate(4));
				event.setEvent_starttime(rs.getString(5));
				event.setEvent_endtime(rs.getString(6));
				event.setCreated_by(rs.getString(7));
				event.setLocation(rs.getString(8));
				
				events.add(event);
			}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		return events;
	}
	
}
