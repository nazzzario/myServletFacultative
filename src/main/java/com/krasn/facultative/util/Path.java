package com.krasn.facultative.util;

public class Path {


    private Path() {
    }


    public static final String WELCOME_PAGE = "main.jsp";

    public static final String FORWARD_TO_LOGIN_FORM = "/WEB-INF/jsp/login.jsp";

    public static final String REDIRECT_TO_LOGIN_FORM = "controller?command=login";

    public static final String FORWARD_TO_ADD_STUDENT_FORM = "/WEB-INF/jsp/add-student-form.jsp";
    public static final String FORWARD_TO_ADD_TEACHER_FORM = "/WEB-INF/jsp/add-teacher-form.jsp";

    public static final String REDIRECT_TO_ADD_STUDENT_FORM = "controller?command=add-student";
    public static final String ERROR_PAGE = "/WEB-INF/jsp/error.jsp";

    public static final String REDIRECT_TO_ADD_TEACHER_FORM = "controller?command=add-teacher";
    public static final String FORWARD_TO_ADD_COURSE_FORM = "/WEB-INF/jsp/add-course-form.jsp";

    public static final String REDIRECT_TO_ADD_COURSE_FORM = "controller?command=add-course";

    public static final String REDIRECT_TO_VIEW_USERS_LIST = "controller?command=list-users";
    public static final String FORWARD_TO_VIEW_USERS_LIST = "/WEB-INF/jsp/list-users.jsp";

    public static final String FORWARD_TO_EDIT_COURSE = "/WEB-INF/jsp/edit-course-form.jsp";
    public static final String REDIRECT_TO_EDIT_COURSE = "controller?command=edit-course";

    public static final String REDIRECT_TO_VIEW_COURSES_LIST = "controller?command=list-courses";
    public static final String FORWARD_TO_VIEW_COURSES_LIST = "/WEB-INF/jsp/list-courses.jsp";

    public static final String REDIRECT_TO_VIEW_COURSES_CATALOG = "controller?command=course-catalog";
    public static final String FORWARD_TO_VIEW_COURSES_CATALOG = "/WEB-INF/jsp/course-catalog.jsp";

}
