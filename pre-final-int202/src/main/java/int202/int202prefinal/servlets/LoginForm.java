package int202.int202prefinal.servlets;

import int202.int202prefinal.entities.Customer;
import int202.int202prefinal.repositories.CustomerRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginForm", value = "/013/login-form")
public class LoginForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login-form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession(false);
        CustomerRepository customerRepository = new CustomerRepository();

        try {
            Customer exitUser = customerRepository.findByCustomerName(username);
            if (exitUser.getCustomerName().compareTo(username) == 0){
                request.setAttribute("errorMsg","This user has Registered");
                if (exitUser.getPassword().compareTo(password) == 0){
                    request.setAttribute("errorMsgPassword","Correct Password");
                    if (session.getAttribute("displayName") == null){
                        session.setAttribute("displayName", exitUser.getCustomerName());
                    }
                    response.sendRedirect("../");
                }
            }
            if (exitUser.getCustomerName().compareTo(username) != 0){
                request.setAttribute("errorMsg","Data not found");
                request.getRequestDispatcher("/login-form.jsp").forward(request,response);
            }
            if (exitUser.getPassword().compareTo(password) != 0){
                request.setAttribute("errorMsgPassword","InCorrect Password");
                request.getRequestDispatcher("/login-form.jsp").forward(request,response);
            }
        } catch (Exception e){
            request.setAttribute("errorMsg","Data not found");
            request.getRequestDispatcher("/login-form.jsp").forward(request,response);
        }




    }
}