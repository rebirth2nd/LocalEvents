package com.eller.sd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eller.sd.bean.*;
import com.eller.sd.services.EventExtractor;
import com.eller.sd.services.SearchServices;
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		SearchServices search= new SearchServices();
		ArrayList<Event> events;
		ArrayList<String> registered = new ArrayList<String>();
		
		new EventExtractor().registeredEvents(registered, (String)request.getSession().getAttribute("username"));
		request.setAttribute("registered", registered);

		if(type.equals("Date")==true)
		{
			events = search.searchByDate(request.getParameter("event_startdate"), request.getParameter("event_enddate"));
		}else
		{
			if(type.equals("Category")==true)
			{
				events = search.searchByTag(request.getParameter("keyword"));
			} else
			{
				events = search.searchByTitle(request.getParameter("keyword"));

			}
		}
		
		request.setAttribute("events", events);
		
		RequestDispatcher rd = request.getRequestDispatcher("Search_Services.jsp");
		rd.forward(request, response);		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
}

}
