package com.krasn.facultative.domain.entity;

import com.krasn.facultative.domain.enums.CourseStatus;
import com.krasn.facultative.domain.Identified;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Course implements Identified<Long>, Serializable {
    private Long id;
    private String courseName;
    private Long subjectId;
    private String subjectName;
    private Long teacherId;
    private String teacherName;
//    private LocalDate startDate;
//    private LocalDate endDate;
    private Date startDate;
    private Date endDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public CourseStatus getCourseStatus() {
        return courseStatus;
    }

    public void setCourseStatus(CourseStatus courseStatus) {
        this.courseStatus = courseStatus;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                ", teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", courseStatus=" + courseStatus +
                '}';
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
