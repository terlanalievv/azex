package az.azex.web.listener;

import az.azex.domain.FlexibleList;
import az.azex.repository.CommonDao;
import az.azex.repository.DatabaseUtility;
import az.azex.repository.implementation.CommonDaoImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.sql.DataSource;
import java.util.List;

@WebListener()
public class AzexApplicationContextListener implements ServletContextListener{

    // Public constructor is required by servlet spec
    public AzexApplicationContextListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */

        DataSource dataSource = DatabaseUtility.getDataSource();
        CommonDao commonDao = new CommonDaoImpl(dataSource);
        List<FlexibleList> allFlexibleList = commonDao.getAllFlexibleList();
        System.out.println("allFlexibleList = " + allFlexibleList);

        for(FlexibleList list : allFlexibleList) {
            sce.getServletContext().setAttribute(list.getName(), list);
        }


    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

}
