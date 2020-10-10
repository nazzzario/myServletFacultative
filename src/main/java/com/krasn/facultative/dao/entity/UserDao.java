package com.krasn.facultative.dao.entity;

import com.krasn.facultative.dao.GenericDao;
import com.krasn.facultative.domain.entity.User;

import java.util.List;

public interface UserDao extends GenericDao<User,Long> {
    User getByLogin(String login);

    List<User> getTeachers();

    List<User> getStudents();

    List<User> getUnblockedStudents();

    List<User> getBlockedStudents();

}
