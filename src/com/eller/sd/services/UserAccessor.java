package com.eller.sd.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.eller.sd.bean.Business_Info;
import com.eller.sd.bean.User;
import com.eller.sd.bean.User_info;
import com.eller.sd.bean.Users;
import com.eller.sd.database.DBConnection;

public class UserAccessor {

	public boolean createUser(Users user,User_info info)
	{
		//Store login information
		boolean success=false;
		String insert_login = "Insert into login(username,password,user_type,user_created_date,user_modified_date,referred_id,email_id) values(?,?,?,?,?,?,?)";
		String insert_user_info = "Insert into user_info(username,first_name,middle_name,last_name,secret_question,secret_answer,fb_link,twitter,contact_number,street,city,state,country) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		DBConnection dbconnection = DBConnection.getDBConnection();
		Connection conn = dbconnection.getConn();
		
		try {
			PreparedStatement login = conn.prepareStatement(insert_login);
			
			login.setString(1, user.getUname());
			login.setString(2, user.getUpass());
			login.setInt(3, user.getUser_type());//integer
			login.setTimestamp(4, user.getUser_created_date());
			login.setTimestamp(5, user.getUser_modified_date());
			login.setInt(6,0);
			login.setString(7, user.getEmail_id());
			
			
			success= login.execute();
			
			//Store user information

			PreparedStatement user_info = conn.prepareStatement(insert_user_info);
			
			user_info.setString(1, info.getUsername());
			user_info.setString(2, info.getFirst_name());
			user_info.setString(3, info.getMiddle_name());
			user_info.setString(4, info.getLast_name());
			user_info.setString(5, info.getSecret_question());
			user_info.setString(6, info.getSecret_answer());
			user_info.setString(7, info.getFb_link());
			user_info.setString(8, info.getTwitter());
			user_info.setString(9, info.getContact_number());
			user_info.setString(10, info.getStreet());
			user_info.setString(11, info.getCity());
			user_info.setString(12, info.getState());
			user_info.setString(13, info.getCountry());
			
			success = user_info.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return true;
		
	}
	
	public boolean createBusiness(Users user,Business_Info info)
	{
		boolean success=false;
		
		String insert_login = "Insert into login (username,password,user_type,user_created_date,user_modified_date,referred_id,email_id) values(?,?,?,?,?,?,?)";
		String insert_business_info = "Insert into business_info (business_name,business_owner,business_street,business_city,business_state,busines_description,business_phone,business_contact_name,business_website,username) values(?,?,?,?,?,?,?,?,?,?)";
		
		DBConnection dbconnection = DBConnection.getDBConnection();
		Connection conn = dbconnection.getConn();
		try {
			PreparedStatement login = conn.prepareStatement(insert_login);
			
			login.setString(1, user.getUname());
			login.setString(2, user.getUpass());
			login.setInt(3, user.getUser_type());//integer
			login.setTimestamp(4, user.getUser_created_date());
			login.setTimestamp(5, user.getUser_modified_date());
			login.setInt(6,0);
			login.setString(7, user.getEmail_id());
			
			success= login.execute();
			
			//Store Business information
			PreparedStatement business = conn.prepareStatement(insert_business_info);
			
			business.setString(1, info.getBusiness_name());
			business.setString(2, info.getBusiness_owner());
			business.setString(3, info.getBusiness_street());
			business.setString(4, info.getBusiness_city());
			business.setString(6, info.getBusiness_description());
			business.setString(5, info.getBusiness_state());
			business.setString(7, info.getBusiness_phone());
			business.setString(8, info.getBusiness_contact_name());
			business.setString(9, info.getBusiness_website());
			business.setString(10, user.getUname());
			
			success = business.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return true;
	}

}
