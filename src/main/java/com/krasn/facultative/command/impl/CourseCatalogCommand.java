package com.krasn.facultative.command.impl;

import com.krasn.facultative.command.FrontCommand;
import com.krasn.facultative.dao.entity.CourseDao;
import com.krasn.facultative.dao.entity.impl.CourseDaoImpl;
import com.krasn.facultative.domain.entity.Course;
import com.krasn.facultative.util.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CourseCatalogCommand extends FrontCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseCatalogCommand.class.getName());

    @Override
    protected String doGet() {
        LOGGER.debug("Entering doGet()");


        CourseDao dao = new CourseDaoImpl();
        List<Course> courses = dao.getAllNotStartedCourses();

        request.setAttribute("catalogCourse",courses );

        LOGGER.trace("Not started course list contains {} items.",courses.size());

        LOGGER.debug("Leaving doGet()");
        return Path.FORWARD_TO_VIEW_COURSES_CATALOG;
    }

    @Override
    protected String doPost() {
        return Path.REDIRECT_TO_VIEW_COURSES_CATALOG;
    }
}
