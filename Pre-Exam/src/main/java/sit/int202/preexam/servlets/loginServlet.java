package sit.int202.preexam.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.preexam.entities.Employee;
import sit.int202.preexam.repository.EmployeeRepository;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/054/login")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee = employeeRepository.findByEmail(email);
        HttpSession session = request.getSession();
        if (employee.getId().equals(pass)){
            session.setAttribute("user",employee);
        }
        request.getRequestDispatcher("/login.jsp").forward(request,response);
    }
}