package com.servlet;

import java.io.IOException;

import com.dao.CompanyDao;
import com.entities.CompanyMaster;

import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/CompServlet")
public class CompServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4394993830885291546L;
	private CompanyDao dao = new CompanyDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String compCode = request.getParameter("compCode");

		if ("delete".equals(action) && compCode != null) {

			dao.deleteCompany(compCode);
			response.sendRedirect("All_Comp.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Get parameters from the request
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

	    // Create a Company object
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

	    // Call the updateCompany method
	    CompanyDao companyDao = new CompanyDao();
	    boolean isUpdated = companyDao.updateCompany(company);

	    if (!isUpdated) {
	        // GSTIN already exists, show error message on edit page
	        request.setAttribute("errorMessage", "Company with this GSTIN is already registered!");

	        // Retain form data
	        request.setAttribute("company", company);
	        
	        request.getRequestDispatcher("Edit_Comp.jsp").forward(request, response);
	    } else {
	        // Redirect to success page
	        response.sendRedirect("All_Comp.jsp");
	    }
	}
}
