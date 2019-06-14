package az.azex.web.filter;

import az.azex.domain.Role;
import az.azex.domain.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static az.azex.web.WebConstants.ATTRIBUTE_LOGIN_TIME;
import static az.azex.web.WebConstants.ATTRIBUTE_USER;

@WebFilter(filterName = "AuthorizationFilter", urlPatterns = "/admin.jsp")
public class AuthorizationFilter implements Filter {

    private List<String> allowedIpList = new ArrayList<>();

    public void destroy() {
        System.out.println("Authorization filter destroy oldu");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession();

        User user = (User) session.getAttribute(ATTRIBUTE_USER);
        LocalDateTime loginTime = (LocalDateTime) session.getAttribute(ATTRIBUTE_LOGIN_TIME);

        boolean isAdmin = false;
        for(Role r : user.getRoles()) {
            if(r.getName().equalsIgnoreCase("admin")) {
                isAdmin = true;
                break;
            }
        }

        String userIp = request.getRemoteHost();
        System.out.println("user ip = " + userIp);

        if(isAdmin && allowedIpList.contains(userIp)) {
            System.out.println("Userin admin rolu var ve ip-e icaze verilib, davam etmeye icaze ver");
            chain.doFilter(request, response);
        } else {
            System.out.println("Userin admin rolu yoxdur ve ya IP-si white listde deyil, access denied sehifesine gonder");
            response.sendRedirect("access-denied.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

        System.out.println("Authorization filter initialize oldu");
        if(config.getInitParameter("ipWhiteList") != null) {
            String[] allowedIps = config.getInitParameter("ipWhiteList").split(",");
            allowedIpList = Arrays.asList(allowedIps);

            System.out.println(allowedIpList);
        }
    }

}
