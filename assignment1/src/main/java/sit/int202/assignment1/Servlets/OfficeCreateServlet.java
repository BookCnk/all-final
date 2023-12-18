package sit.int202.assignment1.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.assignment1.Entities.Office;
import sit.int202.assignment1.Repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeCreateServlet", value = "/OfficeCreateServlet")
public class OfficeCreateServlet extends HttpServlet {
    @Override
    // เมื่อมีการเรียกดูหน้า /OfficeCreateServlet ผ่านเมธอด GET
    // จะทำการส่งผู้ใช้ไปยังหน้า JSP ที่ใช้สำหรับการเพิ่มข้อมูล Office
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/office-add.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ดึงข้อมูลจากฟอร์ม
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        String addressLine1 = request.getParameter("addressLine1");
        String addressLine2 = request.getParameter("addressLine2");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String postalCode = request.getParameter("postalCode");
        String territory = request.getParameter("territory");

        // สร้างอ็อบเจ็กต์ Office และกำหนดค่าข้อมูล
        OfficeRepository officeRepository = new OfficeRepository();;
        Office office = new Office();
        String officeCode = officeRepository.getNewOfficeCode();
        office.setOfficeCode(officeCode);
        office.setCity(city);
        office.setPhoneNumber(phone);
        office.setAddressLine1(addressLine1);
        office.setAddressLine2(addressLine2);
        office.setState(state);
        office.setCountry(country);
        office.setPostalCode(postalCode);
        office.setTerritory(territory);

        // เพิ่มข้อมูล Office ลงในฐานข้อมูล
        officeRepository.insert(office);

        // ตั้งค่าข้อความเมื่อ success และส่งผู้ใช้กลับไปยังหน้า JSP ที่ใช้สำหรับการเพิ่มข้อมูล Office
        request.setAttribute("successMessage", "Add office successfully");
        request.getRequestDispatcher("/office-add.jsp").forward(request, response);
    }
}