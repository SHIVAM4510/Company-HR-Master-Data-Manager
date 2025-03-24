<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Category</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; background-color: #f4f4f4; }
        .container { width: 50%; margin: auto; padding: 20px; border: 1px solid #ccc; border-radius: 5px; background: white; box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1); }
        h2 { color: #333; }
        label { font-weight: bold; display: block; margin-top: 10px; text-align: left; }
        input[type="text"], input[type="submit"], .back-btn { width: 100%; padding: 10px; margin: 5px 0; border: 1px solid #ccc; border-radius: 5px; }
        input[type="submit"] { background: green; color: white; border: none; cursor: pointer; font-size: 16px; }
        input[type="submit"]:hover { background: darkgreen; }
        .back-btn { background: gray; color: white; text-decoration: none; display: block; text-align: center; }
        .back-btn:hover { background: darkgray; }
        .error { color: red; font-weight: bold; margin-bottom: 10px; }
    </style>
</head>
<body>

    <div class="container">
        <h2>Add New Category</h2>

        <%-- Show Error Message if any --%>
        <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
        <% if (errorMessage != null) { %>
            <div class="error"><%= errorMessage %></div>
        <% } %>

        <form action="CategoryServlet" method="post">
            <input type="hidden" name="action" value="add">

            <label>Category Code:</label>
            <input type="text" name="catCd" maxlength="5" required pattern="[A-Za-z0-9]{1,5}" title="Category Code must be alphanumeric and up to 5 characters." />

            <label>Short Name (Max 10 Characters):</label>
            <input type="text" name="catShortname" maxlength="10" required />

            <label>Full Name (Max 20 Characters):</label>
            <input type="text" name="catFullname" maxlength="20" required />

            <input type="submit" value="Add Category">
        </form>

        <a href="All_Categ.jsp" class="back-btn">Go Back</a>
    </div>

</body>
</html>
