package com.masdmtr.dao;

import com.masdmtr.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Created by dmaslov on 28/05/17.
 */


@Repository("mysql")
public class MySqlStudentDaoIml implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class StudentRowMapper implements RowMapper<Student> {


        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setCourse(resultSet.getString("course"));
            return student;
        }
    }

    ;

    @Override
    public Collection<Student> getAllStudents() {
        final String sql = "SELECT id, name, course FROM students";
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        final String sql = "SELECT id, name, course FROM students WHERE id=?";
        Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
        return student;
    }

    @Override
    public void removeStudentById(int id) {
        final String sql = "DELETE FROM students WHERE id=?";
        jdbcTemplate.update(sql, id);


    }

    @Override
    public void updateStudent(Student student) {
        final String sql = "UPDATE students SET name =?, course=? WHERE id = ?";
        final int id = student.getId();
        final String name = student.getName();
        final String course = student.getCourse();


        jdbcTemplate.update(sql, new Object[]{name, course, id});

    }

    @Override
    public void inserStudenttoDb(Student student) {

        final String sql = "INSERT INTO students (name, course) VALUES (?,?)";
        final String name = student.getName();
        final String course = student.getCourse();

        jdbcTemplate.update(sql, new Object[]{name, course});

    }
}
