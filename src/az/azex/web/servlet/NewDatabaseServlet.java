package az.azex.web.servlet;

import az.azex.domain.Person;
import az.azex.repository.DatabaseUtility;
import az.azex.repository.PersonDao;
import az.azex.repository.implementation.PersonDaoPostgreSqlImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "NewDatabaseServlet", urlPatterns = "/newdb")
public class NewDatabaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();

        DataSource dataSource = DatabaseUtility.getDataSource();
        PersonDao personDao = new PersonDaoPostgreSqlImpl(dataSource);

        List<Person> personList = personDao.getPersonList();

        for(Person person : personList) {
            out.println(person.getId() + " " + person.getName() + " " + person.getSurname());
        }
    }
}
