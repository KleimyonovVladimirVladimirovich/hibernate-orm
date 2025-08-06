package container;

import entity.Universities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class HibernateConfig {
//    @Bean
//    public SessionFactory sessionFactory() {
//        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
//        configuration.addAnnotatedClass(Universities.class);
//        configuration.addPackage("container");
//
//        Properties props = new Properties();
//        props.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
//        props.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5438/mydatabase");
//        props.setProperty("hibernate.connection.username", "postgres");
//        props.setProperty("hibernate.connection.password", "root");
//        props.setProperty("hibernate.show_sql", "true");
//        props.setProperty("hibernate.hbm2ddl.auto", "create-drop");
//
//        configuration.addProperties(props);
//
//        return configuration.buildSessionFactory();
//    }
    @Bean
     public static SessionFactory getCurrentSessionFromConfig() {
        org.hibernate.cfg.Configuration config = new org.hibernate.cfg.Configuration();
        config.configure();
        SessionFactory sessionFactory = config.buildSessionFactory();
        return sessionFactory;
    }
}
