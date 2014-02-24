package com.eller.sd.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eller.sd.bean.Business_Info;
import com.eller.sd.bean.User;
import com.eller.sd.bean.User_info;
import com.eller.sd.bean.Users;
import com.eller.sd.factory.UserFactory;
import com.eller.sd.services.UserAccessor;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	UserAccessor register = new UserAccessor();
	boolean success=false;
	
	Users user = UserFactory.userObjects("User");//gets user object from userfactory
	
	user.setUname(request.getParameter("username"));
	user.setUpass(request.getParameter("password"));
	user.setEmail_id(request.getParameter("emailid"));
	
	if(request.getParameter("user_type").equals("0"))
	{
		User_info info = (User_info) UserFactory.userObjects("User_info");//gets user_info object from userfactory
		//create user object and pass

		info.setFirst_name(request.getParameter("first_name"));
		info.setMiddle_name(request.getParameter("middle_name"));
		info.setLast_name(request.getParameter("last_name"));
		info.setSecret_question(request.getParameter("secret_question"));
		info.setSecret_answer(request.getParameter("secret_answer"));
		info.setFb_link(request.getParameter("fb_link"));
		info.setTwitter(request.getParameter("twitter"));
		info.setContact_number(request.getParameter("contact_number"));
		info.setStreet(request.getParameter("street"));
		info.setCity(request.getParameter("city"));
		info.setState(request.getParameter("state"));
		info.setCountry(request.getParameter("country"));	
		
		success=register.createUser(user, info);
		
	}else
	{
		//create business object and pass
		Business_Info info = (Business_Info) UserFactory.userObjects("Business_info");//gets business info object from userfactory
		
		info.setBusiness_name(request.getParameter("business_name"));
		info.setBusiness_owner(request.getParameter("business_owner"));
		info.setBusiness_street(request.getParameter("business_street"));
		info.setBusiness_city(request.getParameter("business_city"));
		info.setBusiness_state(request.getParameter("business_state"));
		info.setBusiness_description(request.getParameter("business_description"));
		info.setBusiness_phone(request.getParameter("business_phone"));
		info.setBusiness_contact_name(request.getParameter("business_contact_name"));
		info.setBusiness_website(request.getParameter("business_website"));
		
		success=register.createBusiness(user, info);
	}
	if(success==true)
	{
		request.getSession().setAttribute("username",request.getParameter("username"));
		RequestDispatcher rd = request.getRequestDispatcher("HomePageServlet");
		rd.forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	
	}

}
