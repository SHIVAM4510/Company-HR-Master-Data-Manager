<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.entities.CompanyMaster, com.dao.CompanyDao"%>

<%
    String compCode = request.getParameter("compCode");
    CompanyDao dao = new CompanyDao();
    CompanyMaster company = dao.getCompanyByCode(compCode);

    if (company == null) {
%>
<h2 style="color: red;">Company not found!</h2>
<a href="All_Comp.jsp">Go Back</a>
<%
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<title>Edit Company Details</title>
<style>
body {
	font-family: Arial, sans-serif;
}

form {
	width: 50%;
	margin: auto;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background: #f9f9f9;
}

label {
	font-weight: bold;
	display: block;
	margin-top: 10px;
}

input[type="text"] {
	width: 100%;
	padding: 8px;
	margin: 5px 0;
}

input[type="submit"], .cancel-btn {
	padding: 10px 15px;
	background: green;
	color: white;
	border: none;
	cursor: pointer;
	margin-top: 15px;
}

.cancel-btn {
	background: red;
	text-decoration: none;
	display: inline-block;
	text-align: center;
	padding: 9px 15px;
	color: white;
}
</style>
</head>
<body>
	<h2>Edit Company</h2>

	<%-- Display error message if present --%>
	<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
	<% if (errorMessage != null) { %>
	<div style="color: red; font-weight: bold;"><%= errorMessage %></div>
	<% } %>

	<form action="CompServlet" method="post">
		<label>Company Code (Read-Only):</label> <input type="text"
			name="compCode" value="<%= company.getCompCode() %>" readonly /><br>

		<label>Company Name:</label> <input type="text" name="compName"
			value="<%= company.getCompName() %>" maxlength="50" required /><br>

		<label>Address Line 1:</label> <input type="text" name="compAdd1"
			value="<%= company.getCompAdd1() %>" maxlength="50" required /><br>

		<label>Address Line 2:</label> <input type="text" name="compAdd2"
			value="<%= company.getCompAdd2() %>" maxlength="50" /><br> <label>Address
			Line 3:</label> <input type="text" name="compAdd3"
			value="<%= company.getCompAdd3() %>" maxlength="50" /><br> <label>Address
			Line 4:</label> <input type="text" name="compAdd4"
			value="<%= company.getCompAdd4() %>" maxlength="50" /><br> <label>Address
			Line 5:</label> <input type="text" name="compAdd5"
			value="<%= company.getCompAdd5() %>" maxlength="50" /><br> <label>City:</label>
		<input type="text" name="city" value="<%= company.getCity() %>"
			maxlength="50" required /><br> <label>State:</label> <input
			type="text" name="state" value="<%= company.getState() %>"
			maxlength="50" required /><br> <label>Pincode:</label> <input
			type="text" name="pincode" value="<%= company.getPincode() %>"
			maxlength="6" pattern="\d{6}" title="Pincode must be 6 digits"
			required /><br> <label>GSTIN:</label> <input type="text"
			name="gstin" value="<%= company.getGstin() %>" maxlength="15"
			pattern="[0-9A-Z]{15}" required
			title="GSTIN must be exactly 15 characters (uppercase letters and numbers only)" /><br>

		<input type="submit" value="Update"> <a href="All_Comp.jsp"
			class="cancel-btn">Cancel</a>
	</form>
</body>
</html>
