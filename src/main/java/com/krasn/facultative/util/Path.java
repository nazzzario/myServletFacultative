package com.krasn.facultative.util;

public class Path {

    private Path() {
    }


    public static final String WELCOME_PAGE = "main.jsp";

    public static final String REDIRECT_TO_LOGIN_FORM = "/WEB-INF/jsp/login.jsp";

    public static final String REDIRECT_TO_VIEW_COURSES_LIST = "controller?command=ListCourses";
    public static final String REDIRECT_TO_COURSES_LIST_FOR_EVALUATION = "controller?command=ListCoursesForEvaluation";


    public static final String FORWARD_TO_ADD_STUDENT_FORM = "/WEB-INF/jsp/add-student-form.jsp";

    public static final String REDIRECT_TO_VIEW_USERS_LIST = "controller?command=ListUsers";
    public static final String REDIRECT_TO_ADD_STUDENT_FORM = "controller?command=AddStudent";
    public static final String ERROR_PAGE = "/WEB-INF/jsp/error.jsp";

}
