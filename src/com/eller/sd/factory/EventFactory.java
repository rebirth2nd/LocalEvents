package com.eller.sd.factory;

import com.eller.sd.bean.Event;
import com.eller.sd.bean.Events;

public class EventFactory {

	public static Events getEventObjects(String objectname)
	{
		if(objectname.equals("Event"))
			return new Event();
		
		return null;
	}
}
