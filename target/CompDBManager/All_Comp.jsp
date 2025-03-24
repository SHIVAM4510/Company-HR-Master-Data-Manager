<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.entities.CompanyMaster, com.dao.CompanyDao" %>
<%
    CompanyDao dao = new CompanyDao();
    List<CompanyMaster> companyList = dao.getAllCompanies();
%>

<!DOCTYPE html>
<html>
<head>
    <title>Company Master</title>
    <style>
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Company Master List</h2>
    <a href="add_company.jsp">Add New Company</a>
    <table>
        <tr>
            <th>Company Code</th>
            <th>Name</th>
            <th>City</th>
            <th>State</th>
            <th>GSTIN</th>
            <th>Actions</th>
        </tr>
        <% for (CompanyMaster company : companyList) { %>
        <tr>
            <td><%= company.getCompCode() %></td>
            <td><%= company.getCompName() %></td>
            <td><%= company.getCity() %></td>
            <td><%= company.getState() %></td>
            <td><%= company.getGstin() %></td>
            <td>
                <a href="edit_company.jsp?compCode=<%= company.getCompCode() %>">Edit</a> | 
                <a href="CompanyServlet?action=delete&compCode=<%= company.getCompCode() %>">Delete</a>
            </td>
        </tr>
        <% } %>
    </table>
</body>
</html>
