package util;

import models.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {

            try {

                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml properties

                Properties settings = new Properties();

                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");

                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/db_usp_disasters?useSSL=false&createDatabaseIfNotExist=true&serverTimezone=UTC&useLegacyDatetimeCode=false");

                settings.put(Environment.USER, "root");

                settings.put(Environment.PASS, "");

                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL57InnoDBDialect");

                settings.put(Environment.SHOW_SQL, "true");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                settings.put(Environment.HBM2DDL_AUTO, "update");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(UserCookie.class);
                configuration.addAnnotatedClass(Disaster.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()

                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        return sessionFactory;

    }

}
