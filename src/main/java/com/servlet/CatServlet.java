package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.dao.CategoryDao;
import com.entities.CategoryMaster;

//@WebServlet("/CatServlet")
public class CatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String catCd = request.getParameter("catCd");
        String catShortname = request.getParameter("catShortname");
        String catFullname = request.getParameter("catFullname");

        CategoryMaster cat = new CategoryMaster(catCd, catShortname, catFullname);
        CategoryDao dao = new CategoryDao();

        boolean success = dao.updateCategory(cat);

        if (success) {
            response.sendRedirect("All_Categ.jsp");
        } else {
            request.setAttribute("errorMessage", "Failed to update category.");
            request.getRequestDispatcher("Edit_Categ.jsp?catCd=" + catCd).forward(request, response);
        }
    }
}
