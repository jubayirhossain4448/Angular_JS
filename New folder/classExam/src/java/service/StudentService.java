package service;


import entity.Student;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;


public class StudentService {

    public static void saveOrUpdate(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.saveOrUpdate(student);
        System.out.println("Success");
        tr.commit();

    }

    public static void delete(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.delete(student);
        System.out.println("Delete Success");
        tr.commit();

    }

    public static List<Student> getList() {
        List<Student> list = new ArrayList<>();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction tr = session.beginTransaction();
            list = session.createQuery("FROM Student").list();

            tr.commit();

        } catch (Exception e) {
            System.out.println("Something Worng");
        }

        return list;

    }
}
