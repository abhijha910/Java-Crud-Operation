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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get parameters from the request
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String phone = request.getParameter("phone");  // New field for phone number
		String address = request.getParameter("address");  // New field for address
		String id = request.getParameter("id");
		int convertedId = Integer.parseInt(id);
		
		// Update the user in the database
		if (UserDBUtil.updateUser(convertedId, fname, lname, phone, address)) { // Pass new fields to updateUser method
			System.out.println("Update Success");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/userProfile.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println("Something went wrong!!!");
		}
	}
}
