package az.azex.web.servlet;

import az.azex.repository.DatabaseUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "DatabaseServlet", urlPatterns = "/db")
public class DatabaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");

        PrintWriter out = response.getWriter();

        out.println("Database servlet");

        DataSource dataSource = DatabaseUtility.getDataSource();

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement("select id, name, surname, status from person where status = 1");
            rs = ps.executeQuery();
            while(rs.next()) {
                out.println(rs.getLong("id")
                        + " " + rs.getString("name")
                        + " " + rs.getString("surname")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseUtility.close(rs, ps, connection);
        }
    }
}
