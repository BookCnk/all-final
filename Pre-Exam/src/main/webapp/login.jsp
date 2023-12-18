<%--
  Created by IntelliJ IDEA.
  User: sorra
  Date: 18/12/2566
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
    <form action="login" method="post">
        email:<input type="email" name="email"><br>
        pass:<input type="password" name="pass"><br>
        <input type="submit" value="login">
        <c:if test="${test != null}">${test}</c:if>
    </form>
</body>
</html>
