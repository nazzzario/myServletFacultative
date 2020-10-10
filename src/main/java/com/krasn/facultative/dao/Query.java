package com.krasn.facultative.dao;

public final class Query {

    private Query() {
    }

    //course
    public static final String INSERT_COURSE = "INSERT INTO course " +
            "(course_name, subject_id,teacher_id, start_date, end_date) " +
            "VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_ALL_COURSES = "SELECT * FROM course";
    public static final String SELECT_UNGROUPED_COURSES = "SELECT subject.subject_name, usr.first_name, usr.last_name, course.*, COUNT(*) AS 'subscribed_by' FROM course_student\n"
            + "RIGHT JOIN course ON course.course_id = course_student.course_id\n"
            + "INNER JOIN subject ON course.subject_id = subject.subject_id\n"
            + "LEFT JOIN usr ON usr.usr_id = course.teacher_id\n";

    public static final String SELECT_LAST_INSERT_COURSE = SELECT_UNGROUPED_COURSES + "WHERE course.course_id = LAST_INSERT_ID() GROUP BY course_student.course_id";


    //user
    public static final String SELECT_ALL_USERS  = "SELECT * FROM usr";
    public static final String SELECT_USER_BY_ID = "SELECT * FROM usr WHERE usr_id = ?";
    public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM usr WHERE login = ?";
    public static final String INSERT_USER = "INSERT INTO usr (login, password, role, first_name, last_name) VALUES (?, ?, ?, ?, ?)";
    public static final String SELECT_LAST_INSERT_USER = "SELECT * FROM usr WHERE usr_id = LAST_INSERT_ID()";

    public static final String SELECT_ALL_TEACHERS = "SELECT * FROM usr WHERE role = 'TEACHER'";

    public static final String SELECT_ALL_SUBJECTS = "SELECT * FROM subject";
}
