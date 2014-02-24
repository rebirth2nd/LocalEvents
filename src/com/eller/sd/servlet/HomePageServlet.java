package com.eller.sd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eller.sd.services.EventExtractor;

/**
 * Servlet implementation class HomePageServlet
 */
@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	EventExtractor currentevents = new EventExtractor();	
	request.setAttribute("events", currentevents.retrieveEvents());
	
	if(request.getSession().getAttribute("username")!=null)
	{
		ArrayList<String> registered_events = new ArrayList<String>();
		currentevents.registeredEvents(registered_events,(String) request.getSession().getAttribute("username"));
		request.setAttribute("registered", registered_events);
	}
	
	RequestDispatcher homejsp = request.getRequestDispatcher("HomePage.jsp");
	homejsp.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	
	}

}
