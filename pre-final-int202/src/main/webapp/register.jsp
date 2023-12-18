<%--
  Created by IntelliJ IDEA.
  User: bookc
  Date: 12/18/2023
  Time: 11:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register form</title>
</head>
<body>
  <form method="post" action="${pageContext.request.contextPath}/013/register">
    <label >First name:</label><br>
     <input type="text" id="firstname" name="firstname"><br>
    <label >Last name:</label><br>
    <input type="text" id="password" name="password">

      <button type="submit">Register</button>
  </form>
</body>
</html>
