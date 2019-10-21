/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corehb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author avis
 */
public class CoreHb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //        firstTime();
                second();
//        fetchDataSecond();
//        thirdMapping();
    }

    public static void firstTime() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("corehb/hibernate.cfg.xml").build();

        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Employee e1 = new Employee();
        e1.setId(101);
        e1.setFirstName("pulkit");
        e1.setLastName("Chawla");

        session.save(e1);
        t.commit();
        System.out.println("successfully saved");
        factory.close();
        session.close();
    }

    public static void second() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("corehb/hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Java is a programming language");
        list1.add("Java is a platform");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Servlet is an Interface");
        list2.add("Servlet is an API");

        Question question1 = new Question();
        question1.setQname("What is Java?");
        question1.setAnswers(list1);

        Question question2 = new Question();
        question2.setQname("What is Servlet?");
        question2.setAnswers(list2);

        session.persist(question1);
        session.persist(question2);

        t.commit();
        session.close();
        System.out.println("success , data stored-----------");
    }

    public static void fetchDataSecond() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("corehb/hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        TypedQuery query = session.createQuery("from Question");
        List<Question> list = query.getResultList();

        Iterator<Question> itr = list.iterator();
        while (itr.hasNext()) {
            Question q = itr.next();
            System.out.println("Question Name: " + q.getQname());
            //printing answers    
            List<String> list2 = q.getAnswers();
            Iterator<String> itr2 = list2.iterator();
            while (itr2.hasNext()) {
                System.out.println(itr2.next());
            }
        }
        session.close();
        System.out.println("successly fetched---------");
    }

    public static void thirdMapping() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("corehb/hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();

        Transaction t = session.beginTransaction();

        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("Java is a programming language", "John Milton");
        map1.put("Java is a platform", "Ashok Kumar");

        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("Servlet technology is a server side programming", "John Milton");
        map2.put("Servlet is an Interface", "Ashok Kumar");
        map2.put("Servlet is a package", "Rahul Kumar");

        QuestionMap question1 = new QuestionMap("What is Java?", "Alok", map1);
        QuestionMap question2 = new QuestionMap("What is Servlet?", "Jai Dixit", map2);

        session.persist(question1);
        session.persist(question2);

        t.commit();
        session.close();
        System.out.println("successfully stored-------");

    }
}
