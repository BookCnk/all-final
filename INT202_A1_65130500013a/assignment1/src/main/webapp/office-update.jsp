<%--
  Created by IntelliJ IDEA.
  User: bookc
  Date: 11/14/2023
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
    <meta charset="UTF-8">
    <title>Office - Add</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Kanit&display=swap" rel="stylesheet">
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
        body {
            margin: 20px;
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
<form action="OfficeUpdateServlet" method="post">
    <h2>Update Office</h2>
    <!-- ใช้ input type="hidden" เพื่อเก็บค่า officeCode และไม่ต้องแสดงให้ผู้ใช้เห็น -->
    <input type="hidden" name="officeCode" required value="${office.officeCode}"><br>

    <label for="city">City:</label>
    <!-- ใช้ value="${office.city}" เพื่อแสดงข้อมูลปัจจุบันของ city -->
    <input type="text" id="city" name="city" required value="${office.city}"><br>

    <label for="phone">Phone:</label>
    <!-- ใช้ value="${office.phoneNumber}" เพื่อแสดงข้อมูลปัจจุบันของ phoneNumber -->
    <input type="text" id="phone" name="phone" required value="${office.phoneNumber}"><br>

<%--<!-- ต่อไปนี้เช่นเดียวกันกับข้างบน ให้ใส่ value="${office.ชื่อ property}" เพื่อแสดงข้อมูลปัจจุบัน -->--%>

    <label for="addressLine1">Address Line 1:</label>
    <input type="text" id="addressLine1" name="addressLine1" required value="${office.addressLine1}"><br>

    <label for="addressLine2">Address Line 2:</label>
    <input type="text" id="addressLine2" name="addressLine2" value="${office.addressLine2}"><br>

    <label for="state">State:</label>
    <input type="text" id="state" name="state" value="${office.state}"><br>

    <label for="country">Country:</label>
    <input type="text" id="country" name="country" required value="${office.country}"><br>

    <label for="postalCode">Postal Code:</label>
    <input type="text" id="postalCode" name="postalCode" required value="${office.postalCode}"><br>

    <label for="territory">Territory:</label>
    <input type="text" id="territory" name="territory" required value="${office.territory}"><br><br>

    <input type="submit" value="Update Office">
</form>

<c:if test="${not empty requestScope.successMessage}">
    <div class="success-message">${requestScope.successMessage}</div>
</c:if>

<div class="center">
    <a href="OfficeListServlet" style="color: white"><button type="button" class="btn btn-primary"> Back </button></a>
</div>
</body>
</html>
