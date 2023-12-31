package sit.int202.classicmodels;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "LoggingFilter" , servletNames = {"AddToCartServlet","OfficeListServlet","ProductListServlet"}) //urlPatterns = "/*"
public class LoggingFilter implements Filter {
    private FilterConfig config;

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        long before = System.currentTimeMillis();
        chain.doFilter(request, response);
        long duration = System.currentTimeMillis() - before;
        String msg = "Resource: " + ((HttpServletRequest) request).getRequestURI() + ", execution time: " + duration + " milliSeconds";
        config.getServletContext().log(msg);
    }

    public void destroy() {
    }
}