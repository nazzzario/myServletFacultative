package com.krasn.facultative.dao;

import com.krasn.facultative.domain.entity.Course;

import java.util.List;

public final class Query {

    private Query() {
    }





    //course
//    public static final String SELECT_UNGROUPED_COURSES = "SELECT subject.subject_name, usr.first_name, usr.last_name, course.*, COUNT(*) AS 'subscribed_by' FROM course_student\n"
//            + "RIGHT JOIN course ON course.course_id = course_student.course_id\n"
//            + "INNER JOIN subject ON course.subject_id = subject.subject_id\n"
//            + "LEFT JOIN usr ON usr.usr_id = course.teacher_id\n";

    public static final String INSERT_COURSE = "INSERT INTO course " +
            "(course_name, subject_id,teacher_id, start_date, end_date) " +
            "VALUES (?, ?, ?, ?, ?)";

    public static final String SELECT_ALL_COURSES = "select course.course_id, course.course_name, subject.subject_name, course.start_date, course.end_date, course.course_status, concat(usr.first_name, ' ', usr.last_name) as teacher\n"
    + "from course\n"
    + "INNER JOIN subject ON course.subject_id = subject.subject_id\n"
    + "inner join usr on course.teacher_id = usr.usr_id ";
    public static final String SELECT_ALL_NOT_STARTED_COURSES =SELECT_ALL_COURSES  + "WHERE course_status = 'NOT_STARTED'";

    public static final String SELECT_LAST_INSERT_COURSE = SELECT_ALL_COURSES + "WHERE course.course_id = LAST_INSERT_ID()";
    public static final String SELECT_COURSE_BY_ID = SELECT_ALL_COURSES + " WHERE course.course_id = ?";
    public static final String UPDATE_COURSE = "UPDATE course SET course_name = ?, subject_id = ?, teacher_id = ?, start_date = ?, end_date = ? WHERE course_id = ?";


    //user
    public static final String SELECT_ALL_USERS  = "SELECT * FROM usr";
    public static final String SELECT_USER_BY_ID = "SELECT * FROM usr WHERE usr_id = ?";
    public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM usr WHERE login = ?";
    public static final String INSERT_USER = "INSERT INTO usr (login, password, role, first_name, last_name) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_LAST_INSERT_USER = "SELECT * FROM usr WHERE usr_id = LAST_INSERT_ID()";

    public static final String SELECT_ALL_STUDENTS = "SELECT * FROM usr WHERE role = 'STUDENT'";
    public static final String SELECT_ALL_TEACHERS = "SELECT * FROM usr WHERE role = 'TEACHER'";

    public static final String SELECT_UNBLOCKED_STUDENTS = "SELECT * FROM usr WHERE role = 'STUDENT' AND blocked = 0";
    public static final String SELECT_BLOCKED_STUDENTS = "SELECT * FROM usr WHERE role = 'STUDENT' AND blocked = 1";

    public static final String UPDATE_USER = "UPDATE usr SET login = ?, password = ?, role = ?, first_name = ?, last_name = ?, blocked = ? WHERE usr_id = ?";


    //subject
    public static final String SELECT_ALL_SUBJECTS = "SELECT * FROM subject";
}
