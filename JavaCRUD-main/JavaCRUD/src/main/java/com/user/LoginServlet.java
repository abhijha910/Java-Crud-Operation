package com.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.UserDBUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve username and password from request
		String uname = request.getParameter("uname");
		String passwd = request.getParameter("passwd");
		
		// Check if login is successful
		if (UserDBUtil.login(uname, passwd)) {
			// Login successful, create session and redirect to user profile page
			HttpSession session = request.getSession();
			session.setAttribute("uname", uname);  // Store username in session
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/userProfile.jsp");
			dispatcher.forward(request, response);
			System.out.println("Login Success");
		} else {
			// Invalid credentials, redirect back to login page with error message
			request.setAttribute("errorMessage", "Invalid username or password!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
			System.out.println("Invalid credentials!!!");
		}
	}
}
