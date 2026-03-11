package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import java.util.List;

public class ClientDemo {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();

        // Insert record using persistent object
        Invoice inv = new Invoice();
        inv.setId(1);
        inv.setName("Anjana");
        inv.setDate("11-03-2026");
        inv.setStatus("Paid");

        session.save(inv);

        session.getTransaction().commit();

        // HQL Query to display all records
        Query q = session.createQuery("from Invoice");

        List<Invoice> list = q.list();

        for(Invoice i : list)
        {
            System.out.println(i.getId()+" "
                    +i.getName()+" "
                    +i.getDate()+" "
                    +i.getStatus());
        }

        session.close();
        factory.close();
    }
}
