<%--
  Created by IntelliJ IDEA.
  User: bookc
  Date: 12/19/2023
  Time: 12:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login-from</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/013/login-form">
  <label >First name:</label><br>
  <input type="text" id="firstname" name="username"><br>
  <label >Last name:</label><br>
  <input type="text" id="password" name="password">
  <button type="submit">Login</button>
</form>
<hr>
<c:if test="${errorMsg != null}">
  <p>${errorMsg}</p>
</c:if>
<c:if test="${errorMsgPassword != null}">
  <p>${errorMsgPassword}</p>
</c:if>
</body>
</html>
