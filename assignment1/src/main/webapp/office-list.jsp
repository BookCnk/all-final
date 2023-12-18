<%--
  Created by IntelliJ IDEA.
  User: bookc
  Date: 11/14/2023
  Time: 4:09 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Kanit&display=swap" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<%--  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">--%>
  <meta charset="UTF-8">
  <title>Office-List</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
      font-family: 'Kanit', sans-serif;
    }

    h2 {
      color: #333;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }

    th, td {
      border: 1px solid #ddd;
      padding: 8px;
      text-align: left;
    }

    th {
      background-color: #f2f2f2;
    }
    .center {
      text-align: center;
    }

  </style>
</head>
<body>

<!-- ส่วนของ Navbar -->
<nav class="navbar bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand">Offices List</a>
    <form class="d-flex" role="search" action="OfficeSearchServlet" method="post">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="Search">
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</nav>

<!-- แสดงรายละเอียดของ Offices ที่ถูกเลือก (ถ้ามี) -->
<c:if test="${not empty requestScope.selectedOffice}">
  <h3>Selected Office Details:</h3>
  <table>
    <tr>
      <th>Office Code</th>
      <th>City</th>
      <th>Phone</th>
      <th>Address Line 1</th>
      <th>Address Line 2</th>
      <th>State</th>
      <th>Country</th>
      <th>Postal Code</th>
      <th>Territory</th>
    </tr>
    <tr>
      <td>${requestScope.selectedOffice.officeCode}</td>
      <td>${requestScope.selectedOffice.city}</td>
      <td>${requestScope.selectedOffice.phoneNumber}</td>
      <td>${requestScope.selectedOffice.addressLine1}</td>
      <td>${requestScope.selectedOffice.addressLine2}</td>
      <td>${requestScope.selectedOffice.state}</td>
      <td>${requestScope.selectedOffice.country}</td>
      <td>${requestScope.selectedOffice.postalCode}</td>
      <td>${requestScope.selectedOffice.territory}</td>
    </tr>
  </table>
</c:if>

<!-- แสดงรายการ Offices ทั้งหมด -->
<h3>List of Offices:</h3>
<table>
  <tr>
    <th>Office Code</th>
    <th>City</th>
    <th>Country</th>
    <th>Action</th>
  </tr>
  <c:if test="${messageErr == null}">
    <c:forEach var="office" items="${offices}">
      <tr>
        <td>${office.officeCode}</td>
        <td>${office.city}</td>
        <td>${office.country}</td>
        <td>
          <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/OfficeListServlet?officeCode=${office.officeCode}">View Details </a>
          <a class="btn btn-outline-warning" href="${pageContext.request.contextPath}/OfficeUpdateServlet?officeCode=${office.officeCode}"> Update</a>
          <a class="btn btn-outline-danger" href="${pageContext.request.contextPath}/OfficeDelServlet?officeCode=${office.officeCode}" onclick="return confirm('Are you sure you want to delete this office?')"> Delete </a>
        </td>${pageContext.request.contextPath}
      </tr>
    </c:forEach>
  </c:if>
</table>

<%--แสดง messageErr เมื่อ Search หาข้อมูลไม่เจอ--%>
<c:if test="${messageErr != null}">
  <!-- ถ้า messageErr ไม่เท่ากับ null -->
  <h2 class="center" style="color: red">${messageErr}<br>
    <a href="OfficeListServlet">
      <!-- ปุ่มที่ให้ผู้ใช้คลิกเพื่อกลับไปยังหน้ารายการ Offices -->
      <button type="button" class="btn btn-outline-secondary">Back To List of Offices</button>
    </a>
  </h2>
</c:if>
<br>
<br>
<%--เป็นปุ่มที่สามารถเข้าไปหน้า Form เพื่อ Add office เพิ่มไปได้ --%>
<div class="center">
  <a href="OfficeCreateServlet" style="color: white"> <button type="button" class="btn btn-primary" > Add Office + </button></a>
</div>

</body>
</html>


