<%--
  Created by IntelliJ IDEA.
  User: bookc
  Date: 12/18/2023
  Time: 8:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit-Office</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/013/office/edit" method="post">
    <h2>Update Office</h2>
    <!-- ใช้ input type="hidden" เพื่อเก็บค่า officeCode และไม่ต้องแสดงให้ผู้ใช้เห็น -->
    <input type="hidden" name="officeCode" required value="${office.officeCode}"><br>

    <label for="city">City:</label>
    <input type="text" id="city" name="city" required value="${office.city}"><br>

    <label for="country">Country:</label>
    <input type="text" id="country" name="country" required value="${office.country}"><br>

    <%--<!-- ต่อไปนี้เช่นเดียวกันกับข้างบน ให้ใส่ value="${office.ชื่อ property}" เพื่อแสดงข้อมูลปัจจุบัน -->--%>
    <label for="addressLine1">Address Line 1:</label>
    <input type="text" id="addressLine1" name="addressLine1" required value="${office.addressLine1}"><br>

    <label for="addressLine2">Address Line 2:</label>
    <input type="text" id="addressLine2" name="addressLine2" value="${office.addressLine2}"><br>
    <input type="submit" value="Update Office">
</form>

<c:if test="${not empty requestScope.successMessage}">
    <div class="success-message">${requestScope.successMessage}</div>
</c:if>

<div class="center">
    <a href="${pageContext.request.contextPath}/013/office" style="color: white"><button type="button" class="btn btn-primary"> Back </button></a>
</div>
</body>
</html>
