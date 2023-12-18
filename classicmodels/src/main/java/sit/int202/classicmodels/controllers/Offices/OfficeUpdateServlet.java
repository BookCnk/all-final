package sit.int202.classicmodels.controllers.Offices;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.repository.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeInsertServlet", value = "/office-update")
public class OfficeUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        HttpSession session = request.getSession();
        String officeCode = request.getParameter("officeCode");
        if (officeCode != null) {
            session.setAttribute("office", officeRepository.find(officeCode));
        }
        getServletContext().getRequestDispatcher("/office_update.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        OfficeRepository officeRepository = new OfficeRepository();
        Office office = (Office) session.getAttribute("office");
        office.setCity(request.getParameter("city"));
        office.setPhone(request.getParameter("phone"));
        office.setAddressLine1(request.getParameter("addressLine1"));
        office.setAddressLine2(request.getParameter("addressLine2"));
        office.setCountry(request.getParameter("country"));
        office.setPostalCode(request.getParameter("postalCode"));
        office.setState(request.getParameter("state"));
        office.setTerritory(request.getParameter("territory"));

        if (officeRepository.update(office)) {
            request.setAttribute("successMessage", "Update office successfully");
        } else {
            request.setAttribute("errorMessage", "Update office failed");
        }
        getServletContext().getRequestDispatcher("/office_update.jsp").forward(request, response);
    }
}