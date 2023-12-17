package sit.int202.assignment1.Servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.assignment1.Repositories.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeListServlet", value = "/OfficeListServlet")
public class OfficeListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ดึง session ที่เกี่ยวข้อง
        HttpSession session = request.getSession();

        // สร้างอ็อบเจ็กต์ OfficeRepository เพื่อดึงข้อมูล Offices จากฐานข้อมูล
        OfficeRepository officeRepository = new OfficeRepository();

        // เก็บข้อมูล Offices ทั้งหมดลงใน session เพื่อนำไปใช้ในหน้า JSP
        session.setAttribute("offices", officeRepository.findAll());

        // ดึง officeCode จาก parameter ของ request
        String officeCode = request.getParameter("officeCode");

        // ถ้ามีการระบุ officeCode, ให้เซ็ต attribute "selectedOffice" เพื่อนำไปใช้ในหน้า JSP
        if (officeCode != null) {
            request.setAttribute("selectedOffice", officeRepository.find(officeCode));
        }

        // ส่ง request ไปยังหน้า JSP (/office-list.jsp) เพื่อแสดงผล
        getServletContext().getRequestDispatcher("/office-list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // ไม่ได้ทำการจัดการในกรณีที่มีการส่ง request แบบ POST
    }
}
