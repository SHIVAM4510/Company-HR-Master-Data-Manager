<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, com.entities.CompanyMaster, com.dao.CompanyDao"%>
<%
CompanyDao dao = new CompanyDao();
List<CompanyMaster> companyList = dao.getAllCompanies();
%>

<!DOCTYPE html>
<html>
<head>
<title>Company Master</title>
<style>
 body {
        font-family: Arial, sans-serif;
        text-align: center;
        background-color: #f2f2f2;
        margin: 20px;
    }
    
    .container {
        width: 80%;
        margin: auto;
        padding: 20px;
        background: #fff;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .home-btn {
        display: inline-block;
        padding: 10px 20px;
        font-size: 16px;
        color: white;
        background: #007BFF;
        text-decoration: none;
        border-radius: 5px;
        margin-bottom: 20px;
        transition: 0.3s;
    }

    .home-btn:hover {
        background: #0056b3;
    }

h2 {
	color: #333;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

th, td {
	border: 1px solid black;
	padding: 10px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

.btn {
	padding: 8px 12px;
	border: none;
	border-radius: 5px;
	text-decoration: none;
	cursor: pointer;
	display: inline-block;
}

.add-btn {
	background: green;
	color: white;
	margin-bottom: 10px;
	display: inline-block;
}

.add-btn:hover {
	background: darkgreen;
}

.edit-btn {
	background: blue;
	color: white;
	margin-right: 5px;
}

.edit-btn:hover {
	background: darkblue;
}

.delete-btn {
	background: red;
	color: white;
}

.delete-btn:hover {
	background: darkred;
}

.action-btns {
	display: flex;
	gap: 10px;
	justify-content: center;
}
</style>
</head>
<body>

	<div class="container">
    <a href="index.jsp" class="home-btn">Home</a>
		<h2>Company Master List</h2>

		<a href="Add_Comp.jsp" class="btn add-btn">Add New Company</a>

		<table>
			<tr>
				<th>Company Code</th>
				<th>Name</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
				<th>Pincode</th>
				<th>GSTIN</th>
				<th>Actions</th>
			</tr>
			<%
			for (CompanyMaster company : companyList) {
			%>
			<tr>
				<td><%=company.getCompCode()%></td>
				<td><%=company.getCompName()%></td>
				<td><%=company.getCompAdd1()%> <%
 if (company.getCompAdd2() != null && !company.getCompAdd2().isEmpty()) {
 %>, <%=company.getCompAdd2()%> <%
 }
 %> <%
 if (company.getCompAdd3() != null && !company.getCompAdd3().isEmpty()) {
 %>, <%=company.getCompAdd3()%> <%
 }
 %> <%
 if (company.getCompAdd4() != null && !company.getCompAdd4().isEmpty()) {
 %>, <%=company.getCompAdd4()%> <%
 }
 %> <%
 if (company.getCompAdd5() != null && !company.getCompAdd5().isEmpty()) {
 %>, <%=company.getCompAdd5()%> <%
 }
 %></td>
				<td><%=company.getCity()%></td>
				<td><%=company.getState()%></td>
				<td><%=company.getPincode()%></td>
				<td><%=company.getGstin()%></td>
				<td class="action-btns"><a
					href="Edit_Comp.jsp?compCode=<%=company.getCompCode()%>"
					class="btn edit-btn">Edit</a> <a
					href="CompServlet?action=delete&compCode=<%=company.getCompCode()%>"
					onclick="return confirm('Are you sure you want to delete this company?');"
					class="btn delete-btn"> Delete</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>

</body>
</html>
