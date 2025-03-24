<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Company</title>
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
        <h2>Add New Company</h2>

        <%-- Show Error Message if GSTIN or CompCode already exists --%>
        <% String errorMessage = (String) request.getAttribute("errorMessage"); %>
        <% if (errorMessage != null) { %>
            <div class="error"><%= errorMessage %></div>
        <% } %>

        <form action="AddCompanyServlet" method="post">
            <label>Company Code (Max 5 Characters):</label>
            <input type="text" name="compCode" maxlength="5" required pattern="[A-Za-z0-9]{1,5}" title="Company Code must be alphanumeric and up to 5 characters." />

            <label>Company Name:</label>
            <input type="text" name="compName" maxlength="50" required />

            <label>Address Line 1:</label>
            <input type="text" name="compAdd1" maxlength="50" required />

            <label>Address Line 2:</label>
            <input type="text" name="compAdd2" maxlength="50" />

            <label>Address Line 3:</label>
            <input type="text" name="compAdd3" maxlength="50" />

            <label>Address Line 4:</label>
            <input type="text" name="compAdd4" maxlength="50" />

            <label>Address Line 5:</label>
            <input type="text" name="compAdd5" maxlength="50" />

            <label>City:</label>
            <input type="text" name="city" maxlength="50" required />

            <label>State:</label>
            <input type="text" name="state" maxlength="50" required />

            <label>Pincode:</label>
            <input type="text" name="pincode" maxlength="6" pattern="\d{6}" title="Pincode must be 6 digits." required />

            <label>GSTIN:</label>
            <input type="text" name="gstin" maxlength="15" pattern="[0-9A-Za-z]{15}" title="GSTIN must be 15 alphanumeric characters." required />

            <input type="submit" value="Add Company">
        </form>

        <a href="All_Comp.jsp" class="back-btn">Go Back</a>
    </div>

</body>
</html>
