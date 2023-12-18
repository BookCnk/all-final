package sit.int202.classicmodels.controllers.Offices;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodels.entities.Office;
import sit.int202.classicmodels.repository.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "OfficeAddServlet", value = "/insert-office")
public class OfficeInsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("addOffice", true);
        getServletContext().getRequestDispatcher("/office_Insert.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        String addressLine1 = request.getParameter("addressLine1");
        String addressLine2 = request.getParameter("addressLine2");
        String state = request.getParameter("state");
        String country = request.getParameter("country");
        String postalCode = request.getParameter("postalCode");
        String territory = request.getParameter("territory");

        if(city.isEmpty() || phone.isEmpty() || addressLine1.isEmpty() || country.isEmpty() || postalCode.isEmpty() || territory.isEmpty()){
            request.setAttribute("errorMessage", "Please fill in complete information.");
            request.getRequestDispatcher("/office_Insert.jsp").forward(request, response);
        }
        OfficeRepository officeRepository = new OfficeRepository();
        Office office = new Office();
        String officeCode = officeRepository.getNewOfficeCode();
        office.setOfficeCode(officeCode);
        office.setCity(city);
        office.setPhone(phone);
        office.setAddressLine1(addressLine1);
        office.setAddressLine2(addressLine2);
        office.setState(state);
        office.setCountry(country);
        office.setPostalCode(postalCode);
        office.setTerritory(territory);
        if (officeRepository.insert(office)) {
            request.setAttribute("successMessage", "Insert office successfully");
        } else {
            request.setAttribute("errorMessage", "Insert office failed");
        }
        getServletContext().getRequestDispatcher("/office_Insert.jsp").forward(request, response);
    }
}