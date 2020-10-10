package com.krasn.facultative.command.impl;

import com.krasn.facultative.command.FrontCommand;
import com.krasn.facultative.dao.entity.CourseDao;
import com.krasn.facultative.dao.entity.SubjectDao;
import com.krasn.facultative.dao.entity.UserDao;
import com.krasn.facultative.dao.entity.impl.CourseDaoImpl;
import com.krasn.facultative.dao.entity.impl.SubjectDaoImpl;
import com.krasn.facultative.dao.entity.impl.UserDaoImpl;
import com.krasn.facultative.domain.entity.Course;
import com.krasn.facultative.domain.entity.Subject;
import com.krasn.facultative.domain.entity.User;
import com.krasn.facultative.domain.enums.CourseStatus;
import com.krasn.facultative.util.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

public class AddCourseCommand extends FrontCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddCourseCommand.class.getName());
    @Override
    protected String doGet( ) {

        LOGGER.debug("Entering doGet()");

        checkOnError();

        SubjectDao subjectDao = new SubjectDaoImpl();
        List<Subject> subjects = subjectDao.getAll();

        UserDao userDao = new UserDaoImpl();
        List<User> teachers = userDao.getTeachers();

        request.setAttribute("subjects", subjects);
        request.setAttribute("teachers", teachers);

        LOGGER.debug("Leaving doGet()");
        return Path.FORWARD_TO_ADD_COURSE_FORM;
    }

    @Override
    protected String doPost( ) {

        LOGGER.debug("Entering doPost()");

        String courseName = request.getParameter("course_name");
        int subjectId = Integer.parseInt(request.getParameter("subject_id"));
        int teacherId = Integer.parseInt(request.getParameter("teacher_id"));
        LocalDate startDate = LocalDate.parse(request.getParameter("start_date"));
        LocalDate endDate = LocalDate.parse(request.getParameter("end_date"));

//        boolean valid = CourseNameValidator.validate(courseName)
//                && DateValidator.validate(startDate, expirationDate);

        if (true) {
            LOGGER.trace("Fields: {}, {},{}, {}, {}", courseName, subjectId, teacherId, startDate, endDate);

            Course course = new Course();
            course.setCourseName(courseName);
            course.setSubjectId((long) subjectId);
            course.setTeacherId((long)teacherId);
            course.setStartDate(startDate);
            course.setEndDate(endDate);
            course.setCourseStatus(CourseStatus.NOT_STARTED);

            CourseDao dao = new CourseDaoImpl();
            course = dao.create(course);

            List<Course> list = dao.getAll();
            request.setAttribute("courses", list);

            LOGGER.trace("The course with id {} added.",course.getId());
        } else {
            LOGGER.trace("Fields failed validation.");
//            return Path.REDIRECT_TO_ADD_COURSE_FORM + "&error=not_valid";
            return Path.REDIRECT_TO_ADD_COURSE_FORM;
        }

        LOGGER.debug("Leaving doPost()");
        return Path.WELCOME_PAGE;
    }
}
