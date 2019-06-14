package az.azex.web.filter;

import az.azex.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

import static az.azex.web.WebConstants.ATTRIBUTE_LOGIN_TIME;
import static az.azex.web.WebConstants.ATTRIBUTE_USER;

@WebFilter(filterName = "AuthenticationFilter", urlPatterns = {"/home.jsp", "/logout", "/admin.jsp"})

public class AuthenticationFilter implements Filter {
    public void destroy() {
        System.out.println("Authentication filter destroy oldu");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute(ATTRIBUTE_USER);
        LocalDateTime loginTime = (LocalDateTime) session.getAttribute(ATTRIBUTE_LOGIN_TIME);

        if(user != null && loginTime != null) {
            System.out.println("User login olub, request davam etsin");
            System.out.println("User = " + user);
            System.out.println("Login time = " + loginTime);
            chain.doFilter(req, resp);
        } else {
            System.out.println("User login olmayib, login sehifesine gonder");
            response.sendRedirect("login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        System.out.println("Authentication filter yarandi");
    }

}
