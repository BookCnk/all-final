<%--
  Created by IntelliJ IDEA.
  User: bookc
  Date: 12/19/2023
  Time: 12:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/013/login">
    <label >First name:</label><br>
    <input type="text" id="firstname" name="fname"><br>
    <label >Last name:</label><br>
    <input type="text" id="password" name="lname">

    <button type="submit">Register</button>
</form>
</body>
</html>
