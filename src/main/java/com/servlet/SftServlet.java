package com.servlet;

import java.io.IOException;
import java.time.LocalTime;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.dao.ShiftDao;
import com.entities.ShiftMaster;

//@WebServlet("/SftServlet")
public class SftServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shiftCd = request.getParameter("shiftCd");
        String shiftName = request.getParameter("shiftName");
        LocalTime shiftIntime = LocalTime.parse(request.getParameter("shiftIntime"));
        LocalTime shiftOuttime = LocalTime.parse(request.getParameter("shiftOuttime"));

        int shiftHour = shiftOuttime.minusHours(shiftIntime.getHour()).getHour();

        ShiftMaster shift = new ShiftMaster(shiftCd, shiftName, shiftIntime, shiftOuttime, shiftHour);
        ShiftDao dao = new ShiftDao();

        boolean success = dao.updateShift(shift);

        if (success) {
            response.sendRedirect("All_Shifts.jsp");
        } else {
            request.setAttribute("errorMessage", "Failed to update shift.");
            request.getRequestDispatcher("Edit_Shift.jsp?shiftCd=" + shiftCd).forward(request, response);
        }
    }
}
