package az.azex.web.servlet;

import az.azex.domain.Order;
import az.azex.domain.User;
import az.azex.repository.CommonDao;
import az.azex.repository.DatabaseUtility;
import az.azex.repository.implementation.CommonDaoImpl;
import az.azex.web.WebConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute(WebConstants.ATTRIBUTE_USER);
        String page = user.getRoles().get(0).getDefaultPage();
        System.out.println("Useri " + page + " sehifesine forward ele");

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
