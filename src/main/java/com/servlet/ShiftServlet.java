package com.servlet;

import java.io.IOException;
import java.time.LocalTime;
import java.time.Duration;
import jakarta.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.dao.ShiftDao;
import com.entities.ShiftMaster;

//@WebServlet("/ShiftServlet")
public class ShiftServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShiftDao shiftDao = new ShiftDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		if ("add".equals(action)) {
			String shiftCd = request.getParameter("shiftCd");
			String shiftName = request.getParameter("shiftName");

			try {
				// Convert string input to LocalTime
				LocalTime shiftIntime = LocalTime.parse(request.getParameter("shiftIntime"));
				LocalTime shiftOuttime = LocalTime.parse(request.getParameter("shiftOuttime"));

				// Calculate shift hours
				int shiftHours = (int) Duration.between(shiftIntime, shiftOuttime).toHours();

				ShiftMaster shift = new ShiftMaster(shiftCd, shiftName, shiftIntime, shiftOuttime, shiftHours);

				String result = shiftDao.saveShift(shift);

				if ("success".equals(result)) {
					response.sendRedirect("All_Shifts.jsp");
				} else {
					// error message
					request.setAttribute("errorMessage", result);
					request.setAttribute("Shift", shift);
					request.getRequestDispatcher("Add_Shift.jsp").forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errorMessage", "Invalid time format!");
				request.getRequestDispatcher("Add_Shift.jsp").forward(request, response);
			}

		} else if ("update".equals(action)) {
			String shiftCd = request.getParameter("shiftCd");
			String shiftName = request.getParameter("shiftName");

			// Convert String input into LocalTime
			LocalTime shiftIntime = LocalTime.parse(request.getParameter("shiftIntime"));
			LocalTime shiftOuttime = LocalTime.parse(request.getParameter("shiftOuttime"));

			// Calculate shift hours (in minutes) and convert to hours
			int shiftHours = (int) Duration.between(shiftIntime, shiftOuttime).toHours();

			ShiftMaster shift = new ShiftMaster(shiftCd, shiftName, shiftIntime, shiftOuttime, shiftHours);
			shiftDao.updateShift(shift);
			response.sendRedirect("All_Shifts.jsp");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String shiftCd = request.getParameter("shiftCd");

		if ("delete".equals(action) && shiftCd != null) {
			shiftDao.deleteShift(shiftCd);
		}
		response.sendRedirect("All_Shifts.jsp");
	}
}
