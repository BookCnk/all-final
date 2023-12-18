package sit.int202.preexam.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.preexam.entities.Employee;
import sit.int202.preexam.repository.EmployeeRepository;
import sit.int202.preexam.repository.OfficeRepository;

import java.io.IOException;

@WebServlet(name = "updateEmployeesServlet", value = "/054/update-employees")
public class updateEmployeesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String employeeNumber = request.getParameter("employeeNumber");
        String officeCode = request.getParameter("officeCode");
        request.setAttribute("employeeNumber", employeeNumber);
        request.setAttribute("officeCode", officeCode);
        request.getRequestDispatcher("/update-employees.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String extension = request.getParameter("extension");
        String email = request.getParameter("email");
        String officeCode = request.getParameter("officeCode");
        String reportsTo = request.getParameter("reportsTo");
        String jobTitle = request.getParameter("officeCode");
        String employeeNumber = request.getParameter("employeeNumber");

        EmployeeRepository employeeRepository = new EmployeeRepository();
        OfficeRepository officeRepository = new OfficeRepository();
        Employee employee = new Employee(employeeNumber,firstName,lastName,extension,email,officeCode,reportsTo,jobTitle,officeRepository.find(officeCode));
        employeeRepository.update(employee);
        request.getRequestDispatcher("/update-employees.jsp").forward(request,response);
    }
}