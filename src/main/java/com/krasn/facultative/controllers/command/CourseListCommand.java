package com.krasn.facultative.controllers.command;

import com.krasn.facultative.models.dao.CourseDao;
import com.krasn.facultative.models.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CourseListCommand extends Command {
    private static final Logger LOGGER = LoggerFactory.getLogger(CourseListCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       List<Course> courseList = CourseDao.findAllCourses();

       request.setAttribute("courseList",courseList);

        return "WEB-INF/jsp/client/courses.jsp";
    }
}
