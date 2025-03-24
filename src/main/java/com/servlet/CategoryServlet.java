package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.dao.CategoryDao;
import com.entities.CategoryMaster;

//@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryDao categoryDao = new CategoryDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            String catCd = request.getParameter("catCd");
            String catShortname = request.getParameter("catShortname");
            String catFullname = request.getParameter("catFullname");

            CategoryMaster category = new CategoryMaster(catCd, catShortname, catFullname);
            String result = categoryDao.saveCategory(category);

            if ("success".equals(result)) {
                response.sendRedirect("All_Categ.jsp");
            } else {
                request.setAttribute("errorMessage", result);
                request.setAttribute("Category", category);
                request.getRequestDispatcher("Add_Categ.jsp").forward(request, response);
            }
        }
    

        else if ("update".equals(action)) {
            String catCd = request.getParameter("catCd");
            String shortName = request.getParameter("catShortname");
            String fullName = request.getParameter("catFullname");

            CategoryMaster cat = new CategoryMaster(catCd, shortName, fullName);
            categoryDao.updateCategory(cat);
            response.sendRedirect("All_Categ.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String catCd = request.getParameter("catCd");

        if ("delete".equals(action) && catCd != null) {
            categoryDao.deleteCategory(catCd);
        }
        response.sendRedirect("All_Categ.jsp");
    }
}
