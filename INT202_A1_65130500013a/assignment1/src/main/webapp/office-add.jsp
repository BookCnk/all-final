<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Office - Add</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            font-family: 'Kanit', sans-serif;
        }

        h2 {
            color: #333;
        }

        form {
            max-width: 400px;
            margin: 20px 0;
            padding: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }

        label {
            display: block;
            margin: 10px 0 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .error-message {
            color: red;
            margin-top: 10px;
        }

        .success-message {
            color: green;
            margin-top: 10px;
        }
        h2 {
            color: #333;
            text-align: center;
        }

        form {
            max-width: 400px;
            margin: 20px auto; /* Center the form horizontally */
            padding: 15px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }

        label {
            display: block;
            margin: 10px 0 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .error-message {
            color: red;
            margin-top: 10px;
        }

        .success-message {
            color: green;
            margin-top: 10px;
            text-align: center;
        }
        .center {
            text-align: center;
        }
    </style>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<h2>Office Add Page</h2>

<%-- ฟอร์มสำหรับเพิ่มข้อมูล Office --%>
<form action="OfficeCreateServlet" method="post">
    <label for="city">City:</label>
    <input type="text" id="city" name="city" required><br>

    <label for="phone">Phone:</label>
    <input type="text" id="phone" name="phone" required><br>

    <label for="addressLine1">Address Line 1:</label>
    <input type="text" id="addressLine1" name="addressLine1" required><br>

    <label for="addressLine2">Address Line 2:</label>
    <input type="text" id="addressLine2" name="addressLine2"><br>

    <label for="state">State:</label>
    <input type="text" id="state" name="state"><br>

    <label for="country">Country:</label>
    <input type="text" id="country" name="country" required><br>

    <label for="postalCode">Postal Code:</label>
    <input type="text" id="postalCode" name="postalCode" required><br>

    <label for="territory">Territory:</label>
    <input type="text" id="territory" name="territory" required><br><br>

    <input type="submit" value="Add Office">
</form>

<%-- แสดงข้อความสำเร็จหลังจากทำการเพิ่ม Office --%>
<c:if test="${not empty requestScope.successMessage}">
    <div class="success-message">${requestScope.successMessage}</div>
</c:if>
<%-- ปุ่ม "Back" เพื่อกลับไปยังหน้ารายการ ListOffices --%>
<div class="center">
    <a href="OfficeListServlet" style="color: white"><button type="button" class="btn btn-primary"> Back </button></a>
</div>
</body>
</html>

