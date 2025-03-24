package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.entities.CompanyMaster;
import com.dao.CompanyDao;

public class AddCompanyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CompanyDao dao = new CompanyDao(); 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String compCode = request.getParameter("compCode");
        String compName = request.getParameter("compName");
        String compAdd1 = request.getParameter("compAdd1");
        String compAdd2 = request.getParameter("compAdd2");
        String compAdd3 = request.getParameter("compAdd3");
        String compAdd4 = request.getParameter("compAdd4");
        String compAdd5 = request.getParameter("compAdd5");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String pincode = request.getParameter("pincode");
        String gstin = request.getParameter("gstin");

        // Create company object
        CompanyMaster company = new CompanyMaster();
        company.setCompCode(compCode);
        company.setCompName(compName);
        company.setCompAdd1(compAdd1);
        company.setCompAdd2(compAdd2);
        company.setCompAdd3(compAdd3);
        company.setCompAdd4(compAdd4);
        company.setCompAdd5(compAdd5);
        company.setCity(city);
        company.setState(state);
        company.setPincode(pincode);
        company.setGstin(gstin);

        
        String errorMessage = dao.addCompany(company);

        if (errorMessage == null) {  
            response.sendRedirect("All_Comp.jsp");
        } else {  
            request.setAttribute("errorMessage", errorMessage);
            request.setAttribute("company", company);
            request.getRequestDispatcher("Add_Comp.jsp").forward(request, response);
        }
    }
}
