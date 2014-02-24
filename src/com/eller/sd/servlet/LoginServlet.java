package com.eller.sd.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eller.sd.bean.User;
import com.eller.sd.bean.Users;
import com.eller.sd.factory.UserFactory;
import com.eller.sd.services.Authenticator;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	Authenticator verify = new Authenticator();
	
	Users user = UserFactory.userObjects("User");
	user.setUname(username);
	user.setUpass(password);
	
	if(verify.authenticate(user))
	{
		HttpSession session = request.getSession();		
		session.setAttribute("username", username);
		response.sendRedirect("HomePageServlet");
	} else{		
		response.sendRedirect("LoginPage.jsp");		
	}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	doGet(request,response);
	}

}
