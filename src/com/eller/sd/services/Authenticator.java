package com.eller.sd.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.eller.sd.bean.User;
import com.eller.sd.bean.Users;
import com.eller.sd.database.DBConnection;

public class Authenticator {
	
	public boolean authenticate(Users user)
	{
		DBConnection dbconnection = DBConnection.getDBConnection();
		Connection conn = dbconnection.getConn();
		
		String query = "select * from login where username = ? and password = ?";
		try {
			PreparedStatement checklogin = conn.prepareStatement(query);
			checklogin.setString(1, user.getUname());
			checklogin.setString(2, user.getUpass());
			
			ResultSet rs = checklogin.executeQuery();
			
			if(rs.next()==true)
				return true;			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
