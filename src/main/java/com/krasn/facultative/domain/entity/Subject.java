package com.krasn.facultative.domain.entity;

import com.krasn.facultative.domain.Identified;

import java.io.Serializable;

public class Subject implements Identified<Long>, Serializable {
    private Long id;
    private String subjectName;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }
}
