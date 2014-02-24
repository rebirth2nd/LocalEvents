package com.eller.sd.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.eller.sd.bean.Event;
import com.eller.sd.database.DBConnection;

public class EventCreator {
	
	public boolean createEvent(Event eventdetails)
	{
		DBConnection dbconnection = DBConnection.getDBConnection();
		Connection conn = dbconnection.getConn();

		String query = "Insert into events(event_name,event_description,total_participants,registration_required,event_type,event_link,event_startdate,event_enddate,event_starthour,event_endhour,event_start_timestamp,event_end_timestamp,created_by,location) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String query2 = "Insert into category(catname,description) values(?,?)";
		String query3 = "insert into event_categories(event_name,cat_name) values(?,?)";
		String category[] = eventdetails.getTags().split(",");
		
		Date start_date = new Date(eventdetails.getEvent_startdate().getTime());
		Date end_date = new Date(eventdetails.getEvent_enddate().getTime());
		
		Timestamp start_timestamps = Timestamp.valueOf(start_date+" "+eventdetails.getEvent_starttime()+":00.0");
		Timestamp end_timestamps = Timestamp.valueOf(end_date+" "+eventdetails.getEvent_endtime()+":00.0");
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, eventdetails.getEvent_name());
			ps.setString(2, eventdetails.getEvent_description());
			ps.setInt(3, eventdetails.getTotal_participants());
			ps.setInt(4, eventdetails.getRegistration_required());
			ps.setInt(5, eventdetails.getEvent_type());
			ps.setString(6, eventdetails.getEvent_link());
			ps.setDate(7, start_date);
			ps.setDate(8, end_date);
			ps.setString(9, eventdetails.getEvent_starttime());
			ps.setString(10, eventdetails.getEvent_endtime());
			ps.setTimestamp(11, start_timestamps);
			ps.setTimestamp(12, end_timestamps);
			ps.setString(13, eventdetails.getCreated_by());
			ps.setString(14, eventdetails.getLocation());
			
			int count = ps.executeUpdate();
			
			PreparedStatement ps1 = conn.prepareStatement(query2);
			PreparedStatement ps2 = conn.prepareStatement(query3);

			for(int i=0;i<category.length;i++)
			{
				try{
				ps1.setString(1, category[i]);
				ps1.setString(2,"");
				ps1.execute();
				} catch(Exception e)
				{
					System.out.println("duplicate value");
					e.printStackTrace();
				}
				ps2.setString(1, eventdetails.getEvent_name());
				ps2.setString(2, category[i]);
				ps2.execute();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return true;
		
	}

}
