package com.krasn.facultative.domain.entity;

import com.krasn.facultative.domain.enums.CourseStatus;
import com.krasn.facultative.domain.Identified;

import java.io.Serializable;
import java.time.LocalDate;

public class Course implements Identified<Long>, Serializable {
    private Long id;
    private String courseName;
    private Long subjectId;
    private Long teacherId;
    private LocalDate startDate;
    private LocalDate endDate;
    private CourseStatus courseStatus;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public CourseStatus getCourseStatus() {
        return courseStatus;
    }


    public void setCourseStatus(CourseStatus courseStatus) {
        this.courseStatus = courseStatus;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", subjectId=" + subjectId +
                ", teacherId=" + teacherId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", courseStatus=" + courseStatus +
                '}';
    }
}
