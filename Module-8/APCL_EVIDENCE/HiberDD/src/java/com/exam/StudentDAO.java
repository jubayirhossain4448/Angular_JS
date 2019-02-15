/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exam;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.event.spi.EventSource;


public class StudentDAO {
    
    public void doSave(Student st){
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(st);
        s.getTransaction().commit();
        s.close();
        
        doShow();
    }
    
    public void doUpdate(Student st){
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(st);
        s.getTransaction().commit();
        s.close();
        
        doShow();
    }
    
    public void doDelete(Student st ){
        
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(st);
        s.getTransaction().commit();
        s.close();
          doShow();
    }
    
    
    
    
    
    public List<Student> doShow(){
        
        List<Student> show=new ArrayList<>();
        Session s = NewHibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Query q = s.createQuery("FROM Student");
        
        show = q.list();
        s.close();
        
        return show;
        
    }
    
    public List<Integer> doLoad(){
       List<Integer> load= new ArrayList<>();
       Session s = NewHibernateUtil.getSessionFactory().openSession();
       s.beginTransaction();
       Query q  = s.createQuery("SELECT s.id FROM Student s");
       load= q.list();
       s.close();
       
       return load;
        
       
    }
    
    public Student ajaxList(int id){
        List<Student> ajax1= new ArrayList<>();
        Session s =NewHibernateUtil.getSessionFactory().openSession();
        Query q =s.createQuery("SELECT s FROM Student s WHERE s.id=:a");
        q.setInteger("a", id);
        
        ajax1=q.list();
        s.close();
        
        if (ajax1.size() > 0) {
            
            return ajax1.get(0);
            
        } else {
            
            return null;
        }
        
        
    }
    
}
