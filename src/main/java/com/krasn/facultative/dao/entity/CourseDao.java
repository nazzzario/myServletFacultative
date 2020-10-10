package com.krasn.facultative.dao.entity;

import com.krasn.facultative.domain.entity.Course;

import java.util.List;

public interface CourseDao {
    Course create(Course course);

    List<Course> getAll();

}


