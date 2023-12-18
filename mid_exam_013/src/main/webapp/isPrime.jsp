<%--
  Created by IntelliJ IDEA.
  User: bookc
  Date: 11/10/2023
  Time: 11:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>isPrime</title>
</head>
<body>
<h1>Midterm Exam Web App by Chanakarn 65130500013</h1>
<h1>Welcome ${name} (${email})</h1>
<hr>
<h1>PrimeChecker :: </h1>
<hr>
<form action="is_Prime" method="post">
    Enter Number to Check :  <input type="text" name="number"><br>
    <c:if test="${message != null}"> <p style="color: red">${message}</p></c:if>
    <input type="submit" value="send">
    <hr>
    <c:if test="${messagePrime != null}"><p style="color: blue">${messagePrime}</p></c:if>
    <br>
    <br>
    <a href="history">history</a>
</form>
</body>
</html>
