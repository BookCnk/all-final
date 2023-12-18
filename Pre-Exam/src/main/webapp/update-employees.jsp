<%--
  Created by IntelliJ IDEA.
  User: sorra
  Date: 18/12/2566
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update-employees</title>
</head>
<body>
<form action="update-employees" method="post">
    firstName:<input type="text" name="firstName"><br>
    lastName:<input type="text" name="lastName"><br>
    extension:<input type="text" name="extension"><br>
    email:<input type="email" name="email"><br>
    <input type="hidden" name="employeeNumber" value="${employeeNumber}">
    <input type="hidden" name="officeCode" value="${officeCode}">
    <input type="hidden" name="reportsTo" value="${sessionScope.user.id}">
    jobTitle:<input type="text" name="jobTitle"><br>
    <input type="submit" value="update">
</form>
</body>
</html>
