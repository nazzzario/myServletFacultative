package com.krasn.facultative.dao.entity;

import com.krasn.facultative.dao.GenericDao;
import com.krasn.facultative.domain.entity.Course;
import com.krasn.facultative.domain.entity.User;

import java.util.List;

public interface CourseDao extends GenericDao<Course, Long> {
    List<Course> getAllNotStartedCourses();
}


