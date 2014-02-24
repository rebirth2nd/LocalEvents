package com.eller.sd.factory;

import com.eller.sd.bean.Business_Info;
import com.eller.sd.bean.User;
import com.eller.sd.bean.User_info;
import com.eller.sd.bean.Users;

public class UserFactory {

	
	public static Users userObjects(String object_name)
	{
		
		if(object_name.equals("User"))
		{
			return new User();
		}else if(object_name.equals("User_info"))
		{
			return new User_info();
		}else if(object_name.equals("Business_info"))
		{
			return new Business_Info();
		}
		
		return null;
	}
}
