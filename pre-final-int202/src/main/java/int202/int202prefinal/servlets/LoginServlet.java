package int202.int202prefinal.servlets;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import int202.int202prefinal.entities.Customer;
import int202.int202prefinal.entities.Employee;
import int202.int202prefinal.repositories.CustomerRepository;
import int202.int202prefinal.repositories.EmployeeRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/013/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action") == null ? "" : request.getParameter("action");
        if (action.equalsIgnoreCase("logout")) {
            request.getSession().setAttribute("currentUser", null);
            response.sendRedirect("../index.jsp");
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        EmployeeRepository employeeRepository = new EmployeeRepository();  // Change this
        Employee currentUser = employeeRepository.findByUserName(userName);
        if (currentUser == null) {
            request.setAttribute("error", "wrong username");
            doGet(request, response);
        } else {
            Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2d, 16, 16);
            char[] passwordArray = password.toCharArray(); //change to toCharArray()
            if (argon2.verify(currentUser.getPassword(), passwordArray)) { //verify
                request.getSession().setAttribute("currentUser", currentUser);
                request.getSession().setAttribute("error", null);
                response.sendRedirect("../index.jsp");
            } else {
                request.setAttribute("error", "wrong password");
                doGet(request, response);
            }
        }
    }
}
