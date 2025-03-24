<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.entities.CompanyMaster, com.dao.CompanyDao" %>

<%
    String compCode = request.getParameter("compCode");
    CompanyDao dao = new CompanyDao();
    CompanyMaster company = dao.getCompanyByCode(compCode);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Company Details</title>
</head>
<body>
    <h2>Edit Company</h2>
    <form action="CompanyServlet" method="post">
    <input type="hidden" name="compCode" value="<%= company.getCompCode() %>" />

    <label>Company Name:</label>
    <input type="text" name="compName" value="<%= company.getCompName() %>" required /><br>

    <label>Address Line 1:</label>
    <input type="text" name="compAdd1" value="<%= company.getCompAdd1() %>" required /><br>

    <label>Address Line 2:</label>
    <input type="text" name="compAdd2" value="<%= company.getCompAdd2() %>" /><br>

    <label>Address Line 3:</label>
    <input type="text" name="compAdd3" value="<%= company.getCompAdd3() %>" /><br>

    <label>Address Line 4:</label>
    <input type="text" name="compAdd4" value="<%= company.getCompAdd4() %>" /><br>

    <label>Address Line 5:</label>
    <input type="text" name="compAdd5" value="<%= company.getCompAdd5() %>" /><br>

    <label>City:</label>
    <input type="text" name="city" value="<%= company.getCity() %>" required /><br>

    <label>State:</label>
    <input type="text" name="state" value="<%= company.getState() %>" required /><br>

    <label>Pincode:</label>
    <input type="text" name="pincode" value="<%= company.getPincode() %>" required /><br>

    <label>GSTIN:</label>
    <input type="text" name="gstin" value="<%= company.getGstin() %>" required /><br>

    <input type="submit" value="Update">
</form>
</body>
</html>
