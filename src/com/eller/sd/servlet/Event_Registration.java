package com.eller.sd.servlet;

import java.io.IOException;
import java.util.ArrayList;

import com.eller.sd.bean.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eller.sd.services.EventExtractor;
import com.eller.sd.services.Registrar;

/**
 * Servlet implementation class Event_Registration
 */
@WebServlet("/Event_Registration")
public class Event_Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Event_Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String eventname=(String) request.getParameter("event_name");
		String username = (String) request.getSession().getAttribute("username");
		String registration_type = (String) request.getParameter("submit");

		Registrar register = new Registrar();

		if(registration_type.equals("Register"))
		{
			register.register(eventname, username);
		} else
		{
			register.unregister(eventname, username);
		}
		
		ArrayList<String> registered = new ArrayList<String>();
		new EventExtractor().registeredEvents(registered, username);		
		request.setAttribute("registered", registered);
		request.setAttribute("events", request.getSession().getAttribute("events"));
		
		RequestDispatcher rd;
		
		if (request.getParameter("page_name").equals("fromsearch")) {
			rd = request.getRequestDispatcher("Search_Services.jsp");
		} else {
			rd = request.getRequestDispatcher("HomePage.jsp");
		}
		
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	doGet(request,response);
	}

}
