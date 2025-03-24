<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Master Tables</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background: linear-gradient(135deg, #74ebd5, #acb6e5);
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 50px;
        }
        .container {
            max-width: 600px;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
        }
        .menu-btn {
            display: block;
            width: 100%;
            margin: 10px 0;
            padding: 12px;
            font-size: 18px;
            border-radius: 5px;
            text-decoration: none;
            transition: all 0.3s ease;
        }
        .menu-btn:hover {
            transform: scale(1.05);
        }
        .company-btn { background: #007bff; color: white; }
        .designation-btn { background: #28a745; color: white; }
        .category-btn { background: #ffc107; color: black; }
        .shift-btn { background: #dc3545; color: white; }
    </style>
</head>
<body>

    <div class="container">
        <h2>Master Tables</h2>
        <a href="All_Comp.jsp" class="menu-btn company-btn">Company Master</a>
        <a href="All_Desg.jsp" class="menu-btn designation-btn">Designation Master</a>
        <a href="All_Categ.jsp" class="menu-btn category-btn">Category Master</a>
        <a href="All_Shifts.jsp" class="menu-btn shift-btn">Shift Master</a>
    </div>

</body>
</html>
