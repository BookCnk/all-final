package int202.prefinalint202.servlets;

import int202.prefinalint202.repositories.CustomerRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RemoveCustomer", value = "/005/customer/remove")
public class RemoveCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerRepository customerRepository = new CustomerRepository();
        String customerNumber = request.getParameter("customerNumber");
        customerRepository.removeCustomer(Integer.parseInt(customerNumber));
        request.getRequestDispatcher("/005/customer").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}