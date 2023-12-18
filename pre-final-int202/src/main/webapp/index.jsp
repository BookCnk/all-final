<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Pre-Final : INT202 ClassicModels</h1>
<br>
<c:if test="${sessionScope.displayName != null}">
    <h2>Hello, ${sessionScope.displayName}</h2>
</c:if>

<c:if test="${sessionScope.currentUser != null}">
    <h2>Hello, ${sessionScope.currentUser.firstName} ${sessionScope.currentUser.lastName}</h2>
</c:if>
<br/>
<c:if test="${sessionScope.currentUser == null}">
    <a href="013/login">Login</a>
</c:if>
<c:if test="${sessionScope.currentUser != null}">
    <a href="013/login?action=logout">Logout</a>
</c:if>
<br>
<a href="013/office">Office List</a>
<br>
<a href="013/employee">Employee List</a><br>
<hr>
<a href="013/register">Register</a><br>
<a href="013/login-form">Login</a>
<hr>
<a href="013/register-send">Register</a>
<a href="013/login-send">Login</a>
</body>
</html>