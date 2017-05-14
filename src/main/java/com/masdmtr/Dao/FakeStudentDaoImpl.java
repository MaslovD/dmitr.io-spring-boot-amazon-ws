package com.masdmtr.Dao;

/**
 * Created by dmaslov on 13/05/17.
 */


import com.masdmtr.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeStudentDaoImpl implements StudentDao {

    private static Map<Integer, Student> students;

    static {

        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Dmitry", "Computer Sciense"));
                put(2, new Student(2, "Anna", "Hardware"));
                put(3, new Student(3, "Boris", "Telecom"));
            }
        };
    }


    @Override
    public Collection<Student> getAllStudents() {

        return this.students.values();

    }


    @Override
    public Student getStudentById(int id) {

        return this.students.get(id);


    }


    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        Student s= students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(),student);



    }


    @Override
    public void inserStudenttoDb(Student student) {
    this.students.put(student.getId(),student);
    }
}