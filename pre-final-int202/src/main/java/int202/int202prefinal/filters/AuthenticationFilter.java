package int202.int202prefinal.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", servletNames = {"OfficeServlet", "EmployeeServlet"}) // add another Servlet
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpSession session = ((HttpServletRequest) request).getSession(false);
        if (session == null || session.getAttribute("currentUser") == null) {
            session.setAttribute("error","PLS LOGIN FIRST");
            ((HttpServletResponse) response).sendRedirect("../013/login");
        } else {
            chain.doFilter(request, response);
        }
    }
}
