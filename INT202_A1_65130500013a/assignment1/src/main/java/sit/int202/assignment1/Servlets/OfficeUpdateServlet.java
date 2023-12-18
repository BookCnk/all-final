package sit.int202.assignment1.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.assignment1.Entities.Office;
import sit.int202.assignment1.Repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeUpdateServlet", value = "/OfficeUpdateServlet")
public class OfficeUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ดึง officeCode จาก parameter ของ request
        String officeCode = request.getParameter("officeCode");

        // สร้างอ็อบเจ็กต์ OfficeRepository เพื่อจัดการกับข้อมูล Offices
        OfficeRepository officeRepository = new OfficeRepository();

        // ดึงข้อมูล Office ที่ต้องการอัปเดตจากฐานข้อมูล
        Office office = officeRepository.find(officeCode);

        // เซ็ต attribute "office" เพื่อนำไปใช้ในหน้า JSP
        request.setAttribute("office", office);

        // ส่ง request ไปยัง "office-update.jsp" เพื่อแสดงฟอร์มอัปเดต
        request.getRequestDispatcher("office-update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // สร้างอ็อบเจ็กต์ OfficeRepository เพื่อจัดการกับข้อมูล Offices
        OfficeRepository officeRepository = new OfficeRepository();

        // ดึงข้อมูลจากฟอร์มที่ผู้ใช้กรอก
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        String addressLine1 = request.getParameter("addressLine1");
        String addressLine2 = request.getParameter("addressLine2");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String postalCode = request.getParameter("postalCode");
        String territory = request.getParameter("territory");
        String officeCode = request.getParameter("officeCode");

        // สร้างอ็อบเจ็กต์ Office และกำหนดค่า
        Office office = new Office();
        office.setOfficeCode(officeCode);
        office.setCity(city);
        office.setPhoneNumber(phone);
        office.setAddressLine1(addressLine1);
        office.setAddressLine2(addressLine2);
        office.setState(state);
        office.setCountry(country);
        office.setPostalCode(postalCode);
        office.setTerritory(territory);

        // เรียกเมธอด update ของ OfficeRepository เพื่ออัปเดตข้อมูลในฐานข้อมูล
        officeRepository.update(office);

        // เซ็ต attribute "successMessage" เพื่อแสดงข้อความสำเร็จในหน้า JSP
        request.setAttribute("successMessage", "Update office successfully");

        // ส่ง request ไปยัง "/office-update.jsp" เพื่อแสดงผล
        request.getRequestDispatcher("/office-update.jsp").forward(request, response);
    }
}
