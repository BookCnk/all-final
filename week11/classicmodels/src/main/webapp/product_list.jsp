<%--
  Created by IntelliJ IDEA.
  User: INT202&204
  Date: 11/6/2023
  Time: 11:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Product List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

<%--<div class="container ml-2 p-2" style="background-color: aliceblue">--%>
<%--    <h2 class="d-flex flex-row" style="color: rebeccapurple">Product List ::</h2>--%>
<%--    <hr>--%>
<%--    <c:forEach items="${products}" var="p" varStatus="vs">--%>
<%--        <div class="row">--%>
<%--            <div class="col-1">${vs.count + (page-1)*pageSize})</div>--%>
<%--            <div class="col-4"> ${p.productCode}: ${p.productName}</div>--%>
<%--            <div class="col-1"> ${p.productScale}</div>--%>
<%--            <div class="col-1" style="text-align: right">${p.price}</div>--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
<%--    <hr>--%>
<%--    <div class="d-flex flex-row">--%>
<%--        <div >Page: </div> &nbsp;--%>
<%--        <c:forEach begin="1" end="${itemCount/pageSize + (itemCount%pageSize>0?1 :0)}" varStatus="vs"> <c:choose>--%>
<%--            <c:when test="${vs.count==page}">--%>
<%--                <button class="p-1 text-danger" style=" border-radius: 4px">${vs.count}</button>--%>
<%--            </c:when>--%>
<%--            <c:otherwise>--%>
<%--            <div class="p-1">--%>
<%--                <a href="product-list?pageSize=${pageSize}&page=${vs.count}"><button style="background-color: antiquewhite;border-radius: 4px">${vs.count}</button></a>--%>
<%--            </div>--%>
<%--        </c:otherwise>--%>
<%--        </c:choose>--%>
<%--        </c:forEach>--%>
<%--    </div>--%>
<%--    <br>--%>
<%--    <button style="background-color: lightpink; border-radius: 4px"><a href="index.jsp">Back</a></button>--%>
</div>
</body>
</html>
