package container;

import entity.Universities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Service {
    public static void main(String[] args) {
       AnnotationConfigApplicationContext context =
               new AnnotationConfigApplicationContext("container");
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        Session session = sessionFactory.openSession();

        Universities universities = new Universities("SPbU", "301", "22.000", "4.7", "5.0");
        Universities universities1 = new Universities("MSU", "259", "", "", "");
        Universities universities2 = new Universities("MIPFI", "150", "","","");
        //все модифицирующие добавления должны быть в транзакциях
        session.beginTransaction();
        session.persist(universities);
        session.persist(universities1);
        session.getTransaction().commit();

        Universities uni = session.get(Universities.class, 1L);
        System.out.println("University with 1'st Primary Key: " + uni);

        Universities uni2 = session.createQuery(
                "SELECT s FROM Universities s WHERE s.id = :id", Universities.class)
                        .setParameter("id",1)
                                .getSingleResult(); //На языке GPQL

        System.out.println("University with 1'st Primary Key: " + uni2);



        session.beginTransaction();
        Universities uniUpdate = session.get(Universities.class, 2L);
        uniUpdate.setUni_rating("4.7");
        uniUpdate.setHow_many_students("30.000");
        session.getTransaction().commit();


        session.beginTransaction();
        Universities uniDelete = session.get(Universities.class, 2L);
        session.remove(uniDelete);

        session.createQuery("DELETE FROM Universities s WHERE s.id = 2")
                        .executeUpdate();
        session.getTransaction().commit();

        List<Universities> allUni = session
                .createQuery("SELECT s FROM Universities s", Universities.class)
                .list();

        session.beginTransaction();
        session.persist(universities2);

        session.getTransaction().commit();

        session.beginTransaction();
           Universities updateMipfi = session.get(Universities.class, 3L);
           updateMipfi.setUni_rating("4.4");
           updateMipfi.setHow_many_students("19.000");
           updateMipfi.setTeacher_rating("4.5");
        session.getTransaction().commit();


        session.beginTransaction();
        Universities universities3 = new Universities("HSE","","","","");
        session.persist(universities3);
        session.getTransaction().commit();

        session.beginTransaction();
        Universities universities4 = new Universities("SYNERGY","-100","1 млн","1.0","-0.1");
        session.persist(universities4);
        session.getTransaction().commit();


     session.close();
    }
}
