<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.entities.ShiftMaster, com.dao.ShiftDao"%>

<%
    String shiftCd = request.getParameter("shiftCd");
    ShiftDao dao = new ShiftDao();
    ShiftMaster shift = dao.getShiftById(shiftCd);

    if (shift == null) {
%>
<h2 style="color: red;">Shift not found!</h2>
<a href="All_Shifts.jsp">Go Back</a>
<%
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<title>Edit Shift</title>
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
    <h2>Edit Shift</h2>

    <form action="SftServlet" method="post">
        <label>Shift Code (Read-Only):</label>
        <input type="text" name="shiftCd" value="<%= shift.getShiftCd() %>" readonly /><br>

        <label>Shift Name:</label>
        <input type="text" name="shiftName" value="<%= shift.getShiftName() %>" maxlength="50" required /><br>

        <label>Shift In-Time:</label>
        <input type="time" name="shiftIntime" value="<%= shift.getShiftIntime() %>" required /><br>

        <label>Shift Out-Time:</label>
        <input type="time" name="shiftOuttime" value="<%= shift.getShiftOuttime() %>" required /><br>

        <label>Shift Hours (Auto-calculated):</label>
        <input type="text" name="shiftHour" value="<%= shift.getShiftHour() %>" readonly /><br>

        <input type="submit" value="Update">
        <a href="All_Shifts.jsp" class="cancel-btn">Cancel</a>
    </form>
</body>
</html>
