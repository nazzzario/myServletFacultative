package com.krasn.facultative.command.impl;

import com.krasn.facultative.command.FrontCommand;
import com.krasn.facultative.dao.entity.UserDao;
import com.krasn.facultative.dao.entity.impl.UserDaoImpl;
import com.krasn.facultative.domain.entity.Course;
import com.krasn.facultative.domain.entity.User;
import com.krasn.facultative.util.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ListUsersCommand extends FrontCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListUsersCommand.class.getName());

    @Override
    protected String doGet() {

        LOGGER.debug("Entering doGet()");

        UserDao dao = new UserDaoImpl();
        List<User> users = dao.getAll();

        request.setAttribute("users", users);
        LOGGER.trace("Users list contains {} items.",users.size());

        LOGGER.debug("Leaving doGet()");
        return Path.FORWARD_TO_VIEW_USERS_LIST;
    }

    @Override
    protected String doPost() {
        return Path.REDIRECT_TO_VIEW_USERS_LIST;
    }
}
