package com.krasn.facultative.domain.entity;

import com.krasn.facultative.domain.Identified;

import java.io.Serializable;

public class Journal implements Identified<Long>, Serializable {
    private Long id;
    private Long studentId;
    private Long courseId;
    private int mark;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", courseId=" + courseId +
                ", mark=" + mark +
                '}';
    }
}
