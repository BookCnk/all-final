package sit.int202.classicmodels.controllers.Offices;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.repository.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeDeleteServlet", value = "/office-delete")
public class OfficeDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        String officeCode = request.getParameter("officeCode");
        if (officeCode != null) {
            if (officeRepository.delete(officeCode)) {
                request.setAttribute("successMessage", "Delete office successfully");
            } else {
                request.setAttribute("errorMessage", "Delete office failed");
            }
        }
        request.getRequestDispatcher("office-edit").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}