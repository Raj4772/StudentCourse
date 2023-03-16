package org.example;

import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

public class StudentRepository {

    private final Session session;

    public StudentRepository(Session session) {
        this.session = session;
    }


    public List<Student> getStudentForGivenCourse(String courseName){

        try{

            TypedQuery<Student> q = enityManager.createQuery("SELECT s FROM student s INNER JOIN student_course sc ON sc.student_id = s.id INNER JOIN courses c ON c.id = sc.course_id WHERE c.name = :name", Student.class);
            q.setParameter("name", courseName);
            return (List<Student>) q.getSingleResult();


        }catch (Exception e) {
            // TODO: handle exception
        }
    }

    public List<Student> getAllStudentNotRegisteredWithCourse(Session session, String courseName){

        try{
            TypedQuery<Student> q = enityManager.createQuery("SELECT s FROM student s WHERE s.id NOT IN (SELECT sc.student_id FROM student_course sc INNER JOIN courses c ON c.id = sc.course_id WHERE c.name = :name)", Student.class);
            q.setParameter("name", courseName);
            return (List<Student>) q.getSingleResult();
        }catch (Exception e) {
            // TODO: handle exception
        }
    }

    public boolean deleteById(Class<Student> type, Serializable id) {
        Student student = session.load(type, id);
        if (student != null) {
            session.delete(student);
            return true;
        }
        return false;
    }
}
