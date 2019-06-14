package az.azex.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

import java.util.concurrent.atomic.AtomicInteger;

import static az.azex.web.WebConstants.ONLINE_USER_COUNTER;

@WebListener()
public class UserCounterListener implements HttpSessionListener {

    // Public constructor is required by servlet spec
    public UserCounterListener() {
    }


    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */

        if(se.getSession().getServletContext().getAttribute(ONLINE_USER_COUNTER) != null) {
            AtomicInteger counter = (AtomicInteger) se.getSession().getServletContext().getAttribute(ONLINE_USER_COUNTER);
            System.out.println("online user sayi = " + counter.incrementAndGet());
        } else {
            AtomicInteger counter = new AtomicInteger(1);
            se.getSession().getServletContext().setAttribute(ONLINE_USER_COUNTER, counter);
            System.out.println("Ilk user xos gelibdi, session id = " + se.getSession().getId());
        }
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        AtomicInteger counter = (AtomicInteger) se.getSession().getServletContext().getAttribute(ONLINE_USER_COUNTER);
        System.out.println("user " + se.getSession().getId() + " sessiyasi oldu, cari user sayi = " + counter.decrementAndGet());

    }


}
