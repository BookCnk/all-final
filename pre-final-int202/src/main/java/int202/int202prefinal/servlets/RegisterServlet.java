package int202.int202prefinal.servlets;

import int202.int202prefinal.entities.Customer;
import int202.int202prefinal.repositories.CustomerRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/013/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String password = request.getParameter("password");

        Customer customer = new Customer();
        customer.setCustomerNumber(497);
        customer.setCustomerName(firstname);
        customer.setContactLastName("x");
        customer.setContactFirstName("x");
        customer.setPhone("123-456-789");
        customer.setAddressLine1("1254/1245");
        customer.setAddressLine2("bkk");
        customer.setCity("bkk");
        customer.setState("BKK");
        customer.setPostalCode("1542");
        customer.setCountry("1542");
        customer.setSalesRepEmployeeNumber(null);
        customer.setCreditLimit(0.00);
        customer.setPassword(password);

        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.insert(customer);
        response.sendRedirect("../");



    }
}