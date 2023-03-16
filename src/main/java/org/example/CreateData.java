package com.javatpoint;

import java.util.ArrayList;

import org.example.Course;
import org.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class CreateData {
    public static void main(String[] args) {

        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession();

        Transaction t=session.beginTransaction();

        Course course1 = new Course();
        course1.setName("Course 1");

        Course course2 = new Course();
        course2.setName("Course 2");

        Course course3 = new Course();
        course3.setName("Course 3");

        Course course4 = new Course();
        course4.setName("Course 4");


        ArrayList<Course> list1 = new ArrayList<>();
        list1.add(course1);
        list1.add(course2);

        ArrayList<Course> list2 = new ArrayList<>();
        list2.add(course3);
        list2.add(course4);

        ArrayList<Course> list3 = new ArrayList<>();
        list3.add(course1);
        list3.add(course4);

        ArrayList<Course> list4 = new ArrayList<>();
        list2.add(course2);
        list2.add(course3);

        Student student1 = new Student();
        student1.setName("Student 1");
        student1.addCourse(course1);
        student1.addCourse(course2);
        //student1.setCourses(list1);

        Student student2 = new Student();
        student2.setName("Student 2");
        student2.addCourse(course2);
        student2.addCourse(course3);
        //student2.setCourses(list2);


        Student student3 = new Student();
        student3.setName("Student 3");
        student3.addCourse(course1);
        student3.addCourse(course4);
        //student3.setCourses(list3);


        Student student4 = new Student();
        student4.setName("Student 4");
        student4.addCourse(course2);
        student4.addCourse(course3);
        //student4.setCourses(list4);

        session.persist(student1);
        session.persist(student2);
        session.persist(student3);
        session.persist(student4);

        t.commit();
        session.close();
        System.out.println("success");
    }
}
