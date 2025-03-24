<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.entities.CategoryMaster, com.dao.CategoryDao"%>

<%
String catCd = request.getParameter("catCd");
CategoryDao dao = new CategoryDao();
CategoryMaster cat = dao.getCategoryById(catCd);

if (cat == null) {
%>
<h2 style="color: red;">Category not found!</h2>
<a href="All_Categ.jsp">Go Back</a>
<%
return;
}
%>

<!DOCTYPE html>
<html>
<head>
<title>Edit Category</title>
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
	<h2>Edit Category</h2>

	<form action="CatServlet" method="post">
		<label>Category Code (Read-Only):</label> <input type="text"
			name="catCd" value="<%=cat.getCatCd()%>" readonly /><br> <label>Short
			Name:</label> <input type="text" name="catShortname"
			value="<%=cat.getCatShortname()%>" maxlength="20" required /><br>

		<label>Full Name:</label> <input type="text" name="catFullname"
			value="<%=cat.getCatFullname()%>" maxlength="50" required /><br>

		<input type="submit" value="Update"> <a href="All_Categ.jsp"
			class="cancel-btn">Cancel</a>
	</form>
</body>
</html>
