package com.jubayir.bean;

import com.jubayir.entity.Student;
import com.jubayir.service.StudentService;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Studentbean {

    private StudentService service = new StudentService();

    private Student student;
    
    private String[] completedCourse;
    
    private List<Student> list;

    public void save() {
        String cc = ", ";
        for(String s : completedCourse){
        cc += s + ", ";
        }
        student.setCompletedCourse(cc);
        service.saveOrUpdate(student);
        student = new Student(); // to avoid updatation of recent/ last entity
    }
    
    public void edit() {
        service.saveOrUpdate(student);
        student = new Student(); // to avoid updatation of recent/ last entity
    }

    public void del() {
        service.delete(student);
    }


    public StudentService getService() {
        return service;
    }

    public void setService(StudentService service) {
        this.service = service;
    }

    public Student getStudent() {
        if (student == null) {
            student = new Student();
        }
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String[] getCompletedCourse() {
        return completedCourse;
    }

    public void setCompletedCourse(String[] completedCourse) {
        this.completedCourse = completedCourse;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }
    
    
}
