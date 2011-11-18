package mywww.project2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 * @author Tolis
 */
@WebListener()
public class ReportContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        
        ServletContext sc = event.getServletContext();
        String reportURI = sc.getInitParameter("reportURI");
        sc.setAttribute("reportURI", reportURI);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
