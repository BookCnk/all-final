<%--
  Created by IntelliJ IDEA.
  User: bookc
  Date: 12/19/2023
  Time: 4:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register-send</title>
</head>
<body>
<h2>Office Add Page</h2>

<%-- ฟอร์มสำหรับเพิ่มข้อมูล Office --%>
<form action="${pageContext.request.contextPath}/013/register-send" method="post">
  <label for="city">firstName:</label>
  <input type="text" id="city" name="firstName" required><br>

  <label for="phone">lastName:</label>
  <input type="text" id="phone" name="lastName" required><br>

  <label for="addressLine1">extension :</label>
  <input type="text" id="addressLine1" name="extension" required><br>

  <label for="addressLine2">email:</label>
  <input type="text" id="addressLine2" name="email" required><br>

  <label for="state">officeCode:</label>
  <input type="text" id="state" name="officeCode" required><br>

  <label for="country">reportsTo:</label>
  <input type="text" id="country" name="country" reportsTo><br>

  <label for="territory">jobTitle:</label>
  <input type="text" id="territory" name="jobTitle" required><br>

  <label for="territory">password:</label>
  <input type="text" id="password" name="password" required><br>

  <br>

  <input type="submit" value="Register">
</form>

<%-- แสดงข้อความสำเร็จหลังจากทำการเพิ่ม Office --%>
<c:if test="${not empty requestScope.successMessage}">
  <div class="success-message">${requestScope.successMessage}</div>
</c:if>
<%-- ปุ่ม "Back" เพื่อกลับไปยังหน้ารายการ ListOffices --%>
<%--<div class="center">--%>
<%--  <a href="OfficeListServlet" style="color: white"><button type="button" class="btn btn-primary"> Back </button></a>--%>
<%--</div>--%>
</body>
</html>
