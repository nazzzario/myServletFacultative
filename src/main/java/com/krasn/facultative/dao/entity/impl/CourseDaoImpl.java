package com.krasn.facultative.dao.entity.impl;

import com.krasn.facultative.dao.Query;
import com.krasn.facultative.dao.entity.CourseDao;
import com.krasn.facultative.domain.entity.Course;
import com.krasn.facultative.domain.enums.CourseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoImpl extends AbstractDao<Course, Long> implements CourseDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseDaoImpl.class.getName());

    @Override
    protected String getInsertQuery() {
        return Query.INSERT_COURSE;
    }

    @Override
    protected void prepareStatementForCreate(PreparedStatement stmt, Course object) {
        try {
            stmt.setString(1, object.getCourseName());
            stmt.setLong(2, object.getSubjectId());
            stmt.setLong(3, object.getTeacherId());
            stmt.setDate(4, object.getStartDate());
            stmt.setDate(5, object.getEndDate());
        } catch (SQLException e) {
            LOGGER.error("Exception while preparing statement for create.\n", e);
        }
    }

    @Override
    protected List<Course> parseResultSet(ResultSet rs) {
        List<Course> list = new ArrayList<>();
        try {
            while (rs.next()) {
                Course course = new Course();
                course.setId(rs.getLong("course_id"));
                course.setCourseName(rs.getString("course_name"));
                course.setSubjectName(rs.getString("subject_name"));
//                course.setTeacherId(rs.getLong("teacher_id"));
                course.setTeacherName(rs.getString("teacher"));
                course.setStartDate(rs.getDate("start_date"));
                course.setEndDate(rs.getDate("end_date"));
                course.setCourseStatus(CourseStatus.valueOf(rs.getString("course_status")));
                list.add(course);
            }
        } catch (SQLException e) {
            LOGGER.error("Exception while parsing result set.\n", e);
        }

        return list;
    }

    @Override
    protected String getSelectByIdQuery() {
        return Query.SELECT_COURSE_BY_ID;
    }

    @Override
    protected String getSelectAllQuery() {
        return Query.SELECT_ALL_COURSES;
    }

    @Override
    protected String getLastInsertId() {
        return Query.SELECT_LAST_INSERT_COURSE;
    }

    @Override
    protected String getUpdateQuery() {
        return Query.UPDATE_COURSE;
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement stmt, Course object) {
        try {
            stmt.setLong(1, object.getId());
            stmt.setString(2, object.getCourseName());
            stmt.setLong(3, object.getSubjectId());
            stmt.setLong(4, object.getTeacherId());
            stmt.setDate(5, object.getStartDate());
            stmt.setDate(6, object.getEndDate());
        } catch (SQLException e) {
            LOGGER.error("Exception while preparing statement for create.\n", e);
        }
    }

    @Override
    protected String getDeleteQuery() {
        return null;
    }

}
