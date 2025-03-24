package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.dao.DesgDao;
import com.entities.DesgMaster;

//@WebServlet("/DesgServlet")
public class DesgServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String desgCd = request.getParameter("desgCd");
        String desgShortname = request.getParameter("desgShortname");
        String desgFullname = request.getParameter("desgFullname");

        DesgMaster desg = new DesgMaster(desgCd, desgShortname, desgFullname);
        DesgDao dao = new DesgDao();

        boolean success = dao.updateDesignation(desg);
        
        if (success) {
            response.sendRedirect("All_Desg.jsp");
        } else {
            request.setAttribute("errorMessage", "Failed to update designation.");
            request.getRequestDispatcher("Edit_Desg.jsp?desgCd=" + desgCd).forward(request, response);
        }
    }
}
