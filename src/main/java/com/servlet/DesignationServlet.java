package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.dao.DesgDao;
import com.entities.DesgMaster;

//@WebServlet("/DesignationServlet")
public class DesignationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private DesgDao designationDao = new DesgDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String desgCd = request.getParameter("desgCd");
            String desgShortname = request.getParameter("desgShortname");
            String desgFullname = request.getParameter("desgFullname");

            DesgMaster designation = new DesgMaster(desgCd, desgShortname, desgFullname);
            String result = designationDao.saveDesignation(designation);

            if ("success".equals(result)) {
                response.sendRedirect("All_Desg.jsp");
            } else {
                request.setAttribute("errorMessage", result);
                request.setAttribute("Designation", designation);
                request.getRequestDispatcher("Add_Desg.jsp").forward(request, response);
            }
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String desgCd = request.getParameter("desgCd");

        if ("delete".equals(action) && desgCd != null) {
            designationDao.deleteDesignation(desgCd);
        }
        response.sendRedirect("All_Desg.jsp");
    }
}
