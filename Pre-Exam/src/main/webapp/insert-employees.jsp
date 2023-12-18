<%--
  Created by IntelliJ IDEA.
  User: sorra
  Date: 18/12/2566
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>insert-employees</title>
</head>
<body>
<form action="insert-employees" method="post">
    firstName:<input type="text" name="firstName"><br>
    lastName:<input type="text" name="lastName"><br>
    extension:<input type="text" name="extension"><br>
    email:<input type="text" name="email"><br>
    <input type="hidden" name="officeCode" value="${officeCode}">
    <input type="hidden" name="reportsTo" value="${sessionScope.user.id}">
    jobTitle:<input type="text" name="jobTitle"><br>
    <input type="submit" value="insert">
</form>
</body>
</html>
