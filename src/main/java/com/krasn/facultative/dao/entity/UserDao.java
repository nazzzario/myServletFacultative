package com.krasn.facultative.dao.entity;

import com.krasn.facultative.dao.GenericDao;
import com.krasn.facultative.domain.entity.User;

public interface UserDao extends GenericDao<User,Long> {
    User getByLogin(String login);

}
