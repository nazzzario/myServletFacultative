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
import com.krasn.facultative.util.Parser;
import com.krasn.facultative.util.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class EditCourseCommand extends FrontCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(EditCourseCommand.class.getName());


    @Override
    protected String doGet() {
        LOGGER.debug("Entering doGet()");

        checkOnError();

        Long courseId = Long.valueOf(request.getParameter("course_id"));
        LOGGER.trace("Course id {}", courseId);
        CourseDao courseDao = new CourseDaoImpl();
        Course course = courseDao.get(courseId);

        SubjectDao subjectDao = new SubjectDaoImpl();
        List<Subject> subjects = subjectDao.getAll();

        UserDao userDao = new UserDaoImpl();
        List<User> teachers = userDao.getTeachers();

        request.setAttribute("course", course);
        request.setAttribute("subjects", subjects);
        request.setAttribute("teachers", teachers);

        LOGGER.debug("Leaving doGet()");

        return Path.FORWARD_TO_EDIT_COURSE;
    }

    @Override
    protected String doPost() {
        LOGGER.debug("Entering doPost()");

        Long courseId = Long.valueOf(request.getParameter("course_id"));
        String courseName = request.getParameter("course_name");
        Long subjectId = Long.valueOf(request.getParameter("subject_id"));
        Long teacherId = Long.valueOf(request.getParameter("teacher_id"));


        Date startDate = Parser.parseDate(request.getParameter("start_date"));
        Date endDate = Parser.parseDate(request.getParameter("end_date"));
        LOGGER.trace("Fields: {}, {}, {}, {}, {}, {}", courseId, courseName, subjectId, teacherId, startDate, endDate);

        CourseDao dao = new CourseDaoImpl();
        Course course = dao.get(courseId);
        course.setCourseName(courseName);
        course.setSubjectId(subjectId);
        course.setTeacherId(teacherId);
        course.setStartDate(startDate);
        course.setEndDate(endDate);
        dao.update(course);

        List<Course> list = dao.getAll();
        request.setAttribute("courses", list);

        SubjectDao subjectDao = new SubjectDaoImpl();
        List<Subject> subjects = subjectDao.getAll();
        request.setAttribute("subjects", subjects);

        UserDao userDao = new UserDaoImpl();
        List<User> teachers = userDao.getTeachers();
        request.setAttribute("teachers", teachers);

        LOGGER.trace("The course with id {} edited.", course.getId());


        LOGGER.debug("Leaving doPost()");
        return Path.REDIRECT_TO_VIEW_COURSES_LIST;
    }
}
