package com.airline.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.airline.dao.BookingDao;

/**
 * Servlet implementation class CancelBookingServlet
 */
@WebServlet("/cancelBooking")
public class CancelBookingServlet extends HttpServlet {
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
		int id = Integer.parseInt(request.getParameter("bookingId"));
		
		boolean status = new BookingDao().cancelFlight(id);
		if(status) {
			response.getWriter().println("<h1>Flight cancel successfully</h1>");
			request.getRequestDispatcher("booking-details.jsp").include(request, response);
		}
		else
		{
			response.getWriter().println("<h1>Flight booked successfully</h1>");
			request.getRequestDispatcher("booking-details.jsp").include(request, response);
		}
	}

}


