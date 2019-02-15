package com.exam;
// Generated Jan 31, 2019 12:00:47 PM by Hibernate Tools 4.3.1

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Student implements java.io.Serializable {

    private int id;
    private String name;
    private String subject;
    private String gender;
    private String password;
    private String round;

    private List<Student> show = new ArrayList<>();
    private List<Integer> load = new ArrayList<>();

    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }

    public Student(int id, String name, String subject, String gender, String password, String round) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.gender = gender;
        this.password = password;
        this.round = round;
    }

    public void doSave() {
        StudentDAO dao = new StudentDAO();
        dao.doSave(this);
        

    }

    public void doUpdate() {

        StudentDAO dao = new StudentDAO();
        dao.doUpdate(this);
    }

    public void doDelete() {

        StudentDAO dao = new StudentDAO();
        dao.doDelete(this);
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRound() {
        return this.round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public List<Student> getShow() {
        StudentDAO dao = new StudentDAO();
        show = dao.doShow();

        return show;
    }

    public void setShow(List<Student> show) {
        this.show = show;
    }

    public List<Integer> getLoad() {
        
        StudentDAO dao = new StudentDAO();
        load = dao.doLoad();
        return load;
    }

    public void setLoad(List<Integer> load) {
        this.load = load;
    }
    
    public void ajaxList(){
        StudentDAO dao = new StudentDAO();
        Student st = dao.ajaxList(id);
        
        while (st !=null) {   
            this.id = st.id;
            this.name= st.name;
            this.subject=st.subject;
            this.gender=st.gender;
            this.password=st.password;
            this.round = st.round;
            
            
        }
        
    }

}
