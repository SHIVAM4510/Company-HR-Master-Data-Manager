<%@page import="com.entities.DesgMaster"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, com.entities.DesgMaster, com.dao.DesgDao"%>
<%
DesgDao dao = new DesgDao();
List<DesgMaster> designationList = dao.getAllDesignations();
%>

<!DOCTYPE html>
<html>
<head>
<title>Designation Master</title>
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
}

.add-btn:hover {
	background: darkgreen;
}

.edit-btn {
	background: blue;
	color: white;
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
	
		<h2>Designation Master List</h2>

		<a href="Add_Desg.jsp" class="btn add-btn">Add New Designation</a>

		<table>
			<tr>
				<th>Designation Code</th>
				<th>Short Name</th>
				<th>Full Name</th>
				<th>Actions</th>
			</tr>
			<%
			for (DesgMaster d : designationList) {
			%>
			<tr>
				<td><%=d.getDesgCd()%></td>
				<td><%=d.getDesgShortname()%></td>
				<td><%=d.getDesgFullname()%></td>
				<td class="action-btns"><a
					href="Edit_Desg.jsp?desgCd=<%=d.getDesgCd()%>"
					class="btn edit-btn">Edit</a> <a
					href="DesignationServlet?action=delete&desgCd=<%=d.getDesgCd()%>"
					onclick="return confirm('Are you sure you want to delete this designation?');"
					class="btn delete-btn">Delete</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>

</body>
</html>
