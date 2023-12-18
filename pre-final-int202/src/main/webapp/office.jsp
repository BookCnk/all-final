<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Office</title>
    <style>
        /* CSS styling for the office container */
        div.office-container {
            border: 1px solid black;
            margin: 10px;
            padding: 10px;
            background-color: #f0f0f0; /* Example background color */
            border-radius: 5px; /* Example border radius */
        }

        /* CSS styling for the office code (h1) */
        h1.office-code {
            font-size: 24px; /* Example font size */
            color: #333; /* Example text color */
        }

        /* CSS styling for the office location (h2) */
        h2.office-location {
            font-size: 18px; /* Example font size */
            color: #666; /* Example text color */
        }

        /* CSS styling for the office address (p) */
        p.office-address {
            font-size: 16px; /* Example font size */
            color: #777; /* Example text color */
        }
    </style>
</head>
<body>
<c:forEach items="${requestScope.officeList}" var="office">
    <div class="office-container">
        <h1 class="office-code">${office.officeCode}</h1>
        <hr>
        <h2 class="office-location">${office.city}, ${office.country}</h2><br>
        <p class="office-address">${office.addressLine1}</p><br>
        <p class="office-address">${office.addressLine2}</p>
<%--        <a href="${pageContext.request.contextPath}/013/office/edit"><button type="button" class="btn btn-success">EDIT OFFICE</button></a>--%>

        <a href="${pageContext.request.contextPath}/013/office/edit?officeCode=${office.officeCode}"><button type="button" class="btn btn-success">EDIT OFFICE</button></a>
    </div>
</c:forEach>
</body>
</html>
