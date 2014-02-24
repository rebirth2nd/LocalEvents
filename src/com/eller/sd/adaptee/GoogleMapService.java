/*
 *  This class is imported from package TravelVoyager, a previous project in mis 510 class, for the benefits of reuse.
 */

package com.eller.sd.adaptee;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GoogleMapService {

	public static void main(String[] args) throws Exception {
		
		GoogleMapService mynJ = new GoogleMapService();
		
		mynJ.addressValidation("1333 N Tyndall Ave. 85719");
		mynJ.computeTravelTime("1333 N Tyndall Ave. 85719", "1400 E. Sixth Street, PO Box 210117, Tucson, AZ 85721");
	
	}
	
	public void computeTravelTime(String start, String destination) throws Exception {
		
		String url = "http://maps.googleapis.com/maps/api/distancematrix/json?origins=" + URLEncoder.encode(start, "utf-8") + "&destinations=" + URLEncoder.encode(destination, "utf-8") + "&mode=walking&sensor=true";
		
		String gsonInput = readUrl(url);
		
		JsonParser jsonParser = new JsonParser();
		
		JsonObject address = jsonParser.parse(gsonInput)
				.getAsJsonObject().getAsJsonArray("rows").get(0)
				.getAsJsonObject().getAsJsonArray("elements").get(0)
				.getAsJsonObject();
		
		String postalCode = address.get("distance")
								.getAsJsonObject().get("text").getAsString();
		
		String walkingTime = address.get("duration")
				.getAsJsonObject().get("text").getAsString();
		
		System.out.println(postalCode);
		System.out.println(walkingTime);
	}

	public String addressValidation(String userInput) throws Exception {
		
		String url="http://maps.googleapis.com/maps/api/geocode/json?address=" + URLEncoder.encode(userInput, "utf-8") + "&sensor=true";
		
		String gsonInput = readUrl(url);
		
		JsonParser jsonParser = new JsonParser();
		JsonObject address = jsonParser.parse(gsonInput)
									.getAsJsonObject().getAsJsonArray("results").get(0)
									.getAsJsonObject();
		
		String postalCode = address.get("formatted_address").getAsString();
	
		return postalCode;
	}
	
	private static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
}
