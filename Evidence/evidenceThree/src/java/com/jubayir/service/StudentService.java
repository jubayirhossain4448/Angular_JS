package com.jubayir.service;

import com.jubayir.entity.Student;
import com.jubayir.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {

    public static void saveOrUpdate(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.saveOrUpdate(student);
        System.out.println("Data Inserted!");
        tr.commit();
    }

    public static void delete(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.delete(student);
        System.out.println("Data Inserted!");
        tr.commit();
    }
    
     @Transactional
    public static Student getById(int id) {
        Student students = new Student();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction tr = session.beginTransaction();
            students = (Student) session.get(Student.class, id);
            tr.commit();
        } catch (Exception e) {
            System.out.println("Something Wrong!");
        }
        return students;
    }

    @Transactional
    public static List<Student> getList() {
        List<Student> student = new ArrayList<>();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction tr = session.beginTransaction();
            student = session.createQuery("FROM Student").list();
            tr.commit();
        } catch (Exception e) {
            System.out.println("Something Wrong!");
        }
        return student;
    }
}
