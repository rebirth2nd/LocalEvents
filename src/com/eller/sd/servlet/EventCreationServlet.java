package com.eller.sd.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eller.sd.bean.Event;
import com.eller.sd.services.EventCreator;

/**
 * Servlet implementation class EventCreationServlet
 */
@WebServlet("/EventCreationServlet")
public class EventCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventCreationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	Event event = new Event();
	
	HttpSession session = request.getSession();
	
	event.setEvent_name(request.getParameter("event_name"));
	event.setEvent_description(request.getParameter("event_description"));
	event.setRegistration_required(Integer.parseInt(request.getParameter("registration_required")));
	event.setEvent_type(Integer.parseInt(request.getParameter("event_type")));
	if(Integer.parseInt(request.getParameter("event_type"))==2)
	{
		event.setTotal_participants(Integer.parseInt(request.getParameter("total_participants")));
	} else
	{
		event.setTotal_participants(0);
	}

	event.setEvent_link(request.getParameter("event_link"));
	event.setLocation(request.getParameter("location"));
	
	try {
		event.setEvent_startdate((new SimpleDateFormat("MM/dd/yyyy").parse((request.getParameter("event_startdate")))));
		event.setEvent_enddate((new SimpleDateFormat("MM/dd/yyyy").parse((request.getParameter("event_enddate")))));
	} catch (ParseException e) {
		e.printStackTrace();
	}
	event.setEvent_starttime(request.getParameter("event_starttime"));
	event.setEvent_endtime(request.getParameter("event_endtime"));
	event.setCreated_by((String)request.getSession().getAttribute("username"));//(String)session.getAttribute("username")
	event.setTags(request.getParameter("event_tags"));
	
	EventCreator registerevent = new EventCreator();
	
	if(registerevent.createEvent(event))
	{
		response.sendRedirect("HomePageServlet");
	}else
	{
		response.sendRedirect("Failure.jsp");
	}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response)	;
}

}
