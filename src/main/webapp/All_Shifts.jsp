<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.entities.ShiftMaster, com.dao.ShiftDao"%>
<%
ShiftDao dao = new ShiftDao();
List<ShiftMaster> shiftList = dao.getAllShifts();
%>

<!DOCTYPE html>
<html>
<head>
<title>Shift Master</title>
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
		<h2>Shift Master List</h2>

		<a href="Add_Shift.jsp" class="btn add-btn">Add New Shift</a>

		<table>
			<tr>
				<th>Shift Code</th>
				<th>Shift Name</th>
				<th>In Time</th>
				<th>Out Time</th>
				<th>Shift Hours</th>
				<th>Actions</th>
			</tr>
			<%
			for (ShiftMaster s : shiftList) {
			%>
			<tr>
				<td><%=s.getShiftCd()%></td>
				<td><%=s.getShiftName()%></td>
				<td><%=s.getShiftIntime()%></td>
				<td><%=s.getShiftOuttime()%></td>
				<td><%=s.getShiftHour()%></td>
				<td class="action-btns"><a
					href="Edit_Shift.jsp?shiftCd=<%=s.getShiftCd()%>"
					class="btn edit-btn">Edit</a> <a
					href="ShiftServlet?action=delete&shiftCd=<%=s.getShiftCd()%>"
					onclick="return confirm('Are you sure you want to delete this shift?');"
					class="btn delete-btn">Delete</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>

</body>
</html>
