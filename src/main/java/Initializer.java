import db.ServiceReturner;
import org.flywaydb.core.Flyway;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class Initializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        sce.getServletContext().setAttribute("database", new ServiceReturner());
        Flyway flyway = Flyway.configure().baselineOnMigrate(true)
                .dataSource("jdbc:postgresql://localhost:5432/oris", "postgres", "root").load();
        flyway.migrate();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServiceReturner serviceReturner = (ServiceReturner) sce.getServletContext().getAttribute("database");
        serviceReturner.close();
    }

}
