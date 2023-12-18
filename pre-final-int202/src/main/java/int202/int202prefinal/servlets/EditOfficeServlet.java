package int202.int202prefinal.servlets;

import int202.int202prefinal.entities.Office;
import int202.int202prefinal.repositories.OfficeRepositoy;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditOfficeServlet", value = "/013/office/edit")
public class EditOfficeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String officeCode = request.getParameter("officeCode");

        // สร้างอ็อบเจ็กต์ OfficeRepository เพื่อจัดการกับข้อมูล Offices
        OfficeRepositoy officeRepository = new OfficeRepositoy();

        // ดึงข้อมูล Office ที่ต้องการอัปเดตจากฐานข้อมูล
        Office office = officeRepository.find(officeCode);

        // เซ็ต attribute "office" เพื่อนำไปใช้ในหน้า JSP
        request.setAttribute("office", office);

        request.getRequestDispatcher("/office-edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ดึงข้อมูลจากฟอร์ม
        String city = request.getParameter("city");
        String addressLine1 = request.getParameter("addressLine1");
        String addressLine2 = request.getParameter("addressLine2");
        String country = request.getParameter("country");

        // สร้างอ็อบเจ็กต์ Office และกำหนดค่าข้อมูล
        OfficeRepositoy officeRepository = new OfficeRepositoy();;
        Office office = new Office();
        String officeCode = officeRepository.getNewOfficeCode();
        office.setOfficeCode(officeCode);
        office.setCity(city);
        office.setAddressLine1(addressLine1);
        office.setAddressLine2(addressLine2);
        office.setCountry(country);

        // เพิ่มข้อมูล Office ลงในฐานข้อมูล
        officeRepository.update(office);

        request.setAttribute("successMessage", "Update office successfully");

        // ตั้งค่าข้อความเมื่อ success และส่งผู้ใช้กลับไปยังหน้า JSP ที่ใช้สำหรับการเพิ่มข้อมูล Office
        request.getRequestDispatcher("/office-edit.jsp").forward(request, response);
//        response.sendRedirect("../013/office/edit");



    }
}