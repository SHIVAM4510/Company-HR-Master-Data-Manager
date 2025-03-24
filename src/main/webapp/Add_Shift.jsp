<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add New Shift</title>
<style>
body {
	font-family: Arial, sans-serif;
	text-align: center;
	background-color: #f4f4f4;
}

.container {
	width: 50%;
	margin: auto;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background: white;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

h2 {
	color: #333;
}

label {
	font-weight: bold;
	display: block;
	margin-top: 10px;
	text-align: left;
}

input[type="text"], input[type="time"], input[type="submit"], .back-btn
	{
	width: 100%;
	padding: 10px;
	margin: 5px 0;
	border: 1px solid #ccc;
	border-radius: 5px;
}

input[type="submit"] {
	background: green;
	color: white;
	border: none;
	cursor: pointer;
	font-size: 16px;
}

input[type="submit"]:hover {
	background: darkgreen;
}

.back-btn {
	background: gray;
	color: white;
	text-decoration: none;
	display: block;
	text-align: center;
}

.back-btn:hover {
	background: darkgray;
}

.error {
	color: red;
	font-weight: bold;
	margin-bottom: 10px;
}
</style>
</head>
<body>

	<div class="container">
		<h2>Add New Shift</h2>

		<%-- Show Error Message if any --%>
		<%
		String errorMessage = (String) request.getAttribute("errorMessage");
		%>
		<%
		if (errorMessage != null) {
		%>
		<div class="error"><%=errorMessage%></div>
		<%
		}
		%>

		<form action="ShiftServlet" method="post">
			<input type="hidden" name="action" value="add"> <label>Shift
				Code (Max 5 Characters):</label> <input type="text" name="shiftCd"
				maxlength="5" required pattern="[A-Za-z0-9]{1,5}"
				title="Shift Code must be alphanumeric and up to 5 characters." />

			<label>Shift Name:</label> <input type="text" name="shiftName"
				maxlength="20" required /> <label>Shift In Time:</label> <input
				type="time" name="shiftIntime" required /> <label>Shift Out
				Time:</label> <input type="time" name="shiftOuttime" required /> <input
				type="submit" value="Add Shift">
		</form>

		<a href="All_Shifts.jsp" class="back-btn">Go Back</a>
	</div>

</body>
</html>
