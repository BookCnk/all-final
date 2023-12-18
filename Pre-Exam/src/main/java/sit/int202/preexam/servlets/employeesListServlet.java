package sit.int202.preexam.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.preexam.repository.EmployeeRepository;
import sit.int202.preexam.repository.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "employeesListServlet", value = "/054/employees-list")
public class employeesListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OfficeRepository officeRepository = new OfficeRepository();
        String officeCode = request.getParameter("officeCode");
        request.setAttribute("employee", officeRepository.find(officeCode));
        request.setAttribute("officeCode", officeCode);
        request.getRequestDispatcher("/employees-list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}