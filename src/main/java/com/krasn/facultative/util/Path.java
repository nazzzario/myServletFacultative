package com.krasn.facultative.util;

public class Path {

    private Path() {
    }



    public static final String WELCOME_PAGE = "main.jsp";

    public static final String REDIRECT_TO_LOGIN_FORM = "/WEB-INF/jsp/login.jsp";

    public static final String FORWARD_TO_ADD_STUDENT_FORM = "/WEB-INF/jsp/add-student-form.jsp";

    public static final String REDIRECT_TO_ADD_STUDENT_FORM = "controller?command=AddStudent";
    public static final String ERROR_PAGE = "/WEB-INF/jsp/error.jsp";

    public static final String FORWARD_TO_ADD_COURSE_FORM = "/WEB-INF/jsp/add-course-form.jsp";

    public static final String REDIRECT_TO_ADD_COURSE_FORM = "controller?command=add-course";
}
