package sit.int202.assignment1.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.assignment1.Repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeDelServlet", value = "/OfficeDelServlet")
public class OfficeDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // สร้างอ็อบเจ็กต์ OfficeRepository เพื่อจัดการกับข้อมูล Offices
        OfficeRepository officeRepository = new OfficeRepository();

        // ดึง officeCode ที่ต้องการลบจาก parameter ของ request
        String officeCode = request.getParameter("officeCode");

        // เรียกเมธอด delete ของ OfficeRepository เพื่อลบข้อมูล Office
        officeRepository.delete(officeCode);

        // ส่ง request ไปยัง "/OfficeListServlet" เพื่อแสดงรายการ Offices หลังจากที่มีการลบข้อมูล
        request.getRequestDispatcher("/OfficeListServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}