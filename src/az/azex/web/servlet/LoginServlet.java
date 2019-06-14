package az.azex.web.servlet;

import az.azex.domain.Role;
import az.azex.domain.User;
import az.azex.repository.DatabaseUtility;
import az.azex.repository.UserDao;
import az.azex.repository.implementation.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static az.azex.web.WebConstants.ATTRIBUTE_LOGIN_TIME;
import static az.azex.web.WebConstants.ATTRIBUTE_USER;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if(request.getParameter("email") != null &&
            request.getParameter("password") != null
        ) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            DataSource dataSource = DatabaseUtility.getDataSource();
            UserDao userDao = new UserDaoImpl(dataSource);

            Optional<User> optionalUser = userDao.authenticate(email, password);

            if(optionalUser.isPresent()) {
                User user = optionalUser.get();

                List<Role> roles = userDao.getUserRoles(user.getId());
                user.setRoles(roles);
                System.out.println(roles);

                HttpSession session = request.getSession();
                session.setAttribute(ATTRIBUTE_USER, user);
                session.setAttribute(ATTRIBUTE_LOGIN_TIME, LocalDateTime.now());
                System.out.println("useri rolune uygun olaraq " + roles.get(0).getDefaultController() + " servlete redirect ele");
                response.sendRedirect(roles.get(0).getDefaultController());
            } else {
                System.out.println("email ve ya sifre sehvdir");
                HttpSession session = request.getSession();
                session.setAttribute("errorMessage", "Email ve ya sifre yanlisdir");
                response.sendRedirect("login.jsp");
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}
