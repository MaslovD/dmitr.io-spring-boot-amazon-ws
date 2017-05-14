package com.masdmtr.Dao;

import com.masdmtr.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;


@Repository
@Qualifier("mongoData")
public class MongoStudentDaoImpl implements StudentDao{
    Connection connection;

    @Override
    public Collection<Student> getAllStudents() {
        return new ArrayList<Student>() {
            {
               add(new Student (1, "Mongo","mongoDB"));
            }


        };
    }

    @Override
    public Student getStudentById(int id) {
        return null;
    }

    @Override
    public void removeStudentById(int id) {

    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void inserStudenttoDb(Student student) {

    }
}
