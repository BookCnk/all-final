<%--
  Created by IntelliJ IDEA.
  User: sorra
  Date: 18/12/2566
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table >
    <tr>
        <th>firstName</th>
        <th>lastName</th>
        <th>extension</th>
        <th>email</th>
        <th>jobTitle</th>
        <th>Manage</th>

    </tr>
    <c:forEach items="${employee.employeeList}" var="e" varStatus="vs">
        <tr>
            <td>${e.firstName}</td>
            <td>${e.lastName}</td>
            <td>${e.extension}</td>
            <td>${e.email}</td>
            <td>${e.jobTitle}</td>
            <td><a href="delete-employees?employeeNumber=${e.id}">delete</a>
                <a href="update-employees?employeeNumber=${e.id}&officeCode=${officeCode}">update</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<button><a href="insert-employees?officeCode=${officeCode}">insert</a></button>
<c:choose>
    <c:when test="${sessionScope.user ==null}">
        <button><a href="054/login">login</a></button>
    </c:when>
    <c:otherwise>
        <button><a href="054/logout">logout</a></button>
    </c:otherwise>
</c:choose>
</body>
</html>
