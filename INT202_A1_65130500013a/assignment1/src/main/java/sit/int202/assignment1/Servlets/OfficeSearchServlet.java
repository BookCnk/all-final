package sit.int202.assignment1.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.assignment1.Entities.Office;
import sit.int202.assignment1.Repositories.OfficeRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "OfficeSearchServlet", value = "/OfficeSearchServlet")
public class OfficeSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ไม่ได้ใช้ GET ในที่นี้
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // สร้างอ็อบเจ็กต์ OfficeRepository เพื่อจัดการกับข้อมูล Offices
        OfficeRepository officeRepository = new OfficeRepository();

        // ดึงข้อมูลที่ผู้ใช้กรอกในฟอร์มค้นหา
        String searchCountry = request.getParameter("Search");

        // ค้นหา Offices จากฐานข้อมูล โดยใช้เมธอด findByCityOrCountry
        List<Office> foundOffices = officeRepository.findByCityOrCountry(searchCountry);

        // ตรวจสอบว่ามีข้อมูลที่ค้นหาเจอหรือไม่
        if (foundOffices.isEmpty()) {
            // ถ้าไม่พบข้อมูล กำหนด attribute "messageErr" และส่งกลับไปที่หน้า JSP
            request.setAttribute("messageErr", "NOT FOUND DATA");
            request.getRequestDispatcher("/office-list.jsp").forward(request, response);
        }

        // ถ้าพบข้อมูล กำหนด attribute "offices" และส่งกลับไปที่หน้า JSP
        request.setAttribute("offices", foundOffices);
        request.getRequestDispatcher("/office-list.jsp").forward(request, response);
    }
}
