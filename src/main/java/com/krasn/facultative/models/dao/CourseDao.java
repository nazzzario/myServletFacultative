package com.krasn.facultative.models.dao;

import com.krasn.facultative.models.HikariConnectionPoll;
import com.krasn.facultative.models.entity.Course;
import com.krasn.facultative.models.enumeration.Status;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CourseDao {
    private static final String SQL_FIND_ALL_COURSES =
            "SELECT * FROM course WHERE status='NOT_STARTED'";

    public static List<Course> findAllCourses(){
        List<Course> courseList = new ArrayList<>();
        try {
            CourseMapper courseMapper = new CourseMapper();
            Connection connection = HikariConnectionPoll.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_FIND_ALL_COURSES);
            while (resultSet.next()){
                courseList.add(courseMapper.mapRow(resultSet));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return courseList;
    }

    private static class CourseMapper implements EntityMapper<Course> {

        @Override
        public Course mapRow(ResultSet rs) {
            try {
                Course course = new Course();
                course.setId(rs.getInt("course_id"));
                course.setCourseName(rs.getString("course_name"));
                course.setStartDate(rs.getDate("start_date").toLocalDate());
                course.setEndDate(rs.getDate("end_date").toLocalDate());
                course.setDescription(rs.getString("description"));
                course.setStatus(Status.valueOf(rs.getString("status")));
                course.setSubjectId(rs.getInt("subject_id"));
                course.setTeacherId(rs.getInt("techer_id"));
                return course;
            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
