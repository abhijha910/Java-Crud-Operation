package com.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utility.UserDBUtil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve parameters from the request
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String uname = request.getParameter("uname");
		String passwd = request.getParameter("passwd");
		String phone = request.getParameter("phone");   // New field for phone number
		String address = request.getParameter("address"); // New field for address
		
		// Call the addUser method and pass the new parameters
		if (UserDBUtil.addUser(fname, lname, email, uname, passwd, phone, address)) { // Updated method call
			System.out.println("Success"); // for testing, Normally redirect to another page
			
			// Forward to login page after successful registration
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println("Something went wrong!!!");
		}
	}

}
