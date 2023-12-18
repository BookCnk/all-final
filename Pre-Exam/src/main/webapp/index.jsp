<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="054/offices-list">offices-list</a>
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