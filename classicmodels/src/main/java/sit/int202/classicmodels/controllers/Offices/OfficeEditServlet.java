package sit.int202.classicmodels.controllers.Offices;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.repository.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeEditServlet", value = "/office-edit")
public class OfficeEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OfficeRepository officeRepository = new OfficeRepository();
        session.setAttribute("offices", officeRepository.findAll());
        getServletContext().getRequestDispatcher("/office_edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}