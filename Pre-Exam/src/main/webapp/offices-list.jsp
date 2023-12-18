<%--
  Created by IntelliJ IDEA.
  User: sorra
  Date: 18/12/2566
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>offices-list</title>
</head>
<body>
<table >
    <tr>
        <th>city</th>
        <th>phone</th>
        <th>addressLine1</th>
        <th>state</th>
        <th>country</th>
        <th>Manage</th>
    </tr>
    <c:forEach items="${All_Offices}" var="o" varStatus="vs">
        <tr>
            <td>${o.city}</td>
            <td>${o.phone}</td>
            <td>${o.addressLine1}</td>
            <td>${o.state}</td>
            <td>${o.country}</td>
            <td><a href="employees-list?officeCode=${o.officeCode}">Manage</a></td>
        </tr>
    </c:forEach>
</table>
<br>
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
