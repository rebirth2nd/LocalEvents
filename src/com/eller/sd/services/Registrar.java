package com.eller.sd.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.eller.sd.bean.User;
import com.eller.sd.bean.User_info;
import com.eller.sd.database.DBConnection;

public class Registrar {

public void register(String Event_name,String user_name)
{
	
	DBConnection dbconnection = DBConnection.getDBConnection();
	Connection conn = dbconnection.getConn();
	
	String query = "Insert into interested(event_id,user_id) values(?,?)";
	
	try {
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, Event_name);
		ps.setString(2, user_name);

		ps.execute();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
}

public void unregister(String eventname, String username) {

	
	DBConnection dbconnection = DBConnection.getDBConnection();
	Connection conn = dbconnection.getConn();
	
	String query = "delete from happening_modified.interested where event_id = ? and user_id = ?";
	
	try {
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, eventname);
		ps.setString(2, username);

		ps.execute();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	
	
}
	
}
