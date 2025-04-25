package com.airline.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.airline.entity.User;
import com.airline.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User loggedInUser;
		try {
			loggedInUser = new UserService().loginUser(email, password);
			if(loggedInUser != null) {
				out.println("<h3>Welcome "+ loggedInUser.getName()+ "</h3>");
			HttpSession session = 	request.getSession();
			session.setAttribute("userId", loggedInUser.getId());
				response.sendRedirect("search.jsp");
			}
			else {
				out.println("<h3>Invalid Credentials!! try again</h3>");
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
