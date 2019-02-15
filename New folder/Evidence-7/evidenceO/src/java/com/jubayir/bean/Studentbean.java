package com.jubayir.bean;

import com.jubayir.entity.Student;
import com.jubayir.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Studentbean {

    private StudentService service = new StudentService();
    private Student student;

    private List<Student> list;

    private String[] subjects;

    public void save() {
        String cc = " ";
        for (String s : subjects) {
            cc += s + " , ";
        }
        student.setSubject(cc);
        service.saveOrUpdate(student);
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

    public List<Student> getList() {
        list = new ArrayList<>();
        list = service.getList();
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public String[] getSubjects() {
        return subjects;
    }

    public void setSubjects(String[] subjects) {
        this.subjects = subjects;
    }

}
