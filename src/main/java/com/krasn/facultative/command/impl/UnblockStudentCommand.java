package com.krasn.facultative.command.impl;

import com.krasn.facultative.command.FrontCommand;
import com.krasn.facultative.dao.entity.UserDao;
import com.krasn.facultative.dao.entity.impl.UserDaoImpl;
import com.krasn.facultative.domain.entity.User;
import com.krasn.facultative.domain.enums.UserRole;
import com.krasn.facultative.util.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class UnblockStudentCommand extends FrontCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(UnblockStudentCommand.class.getName());

    @Override
    protected String doGet() {

        LOGGER.debug("Entering doGet()");

        checkOnError();

        UserDao dao = new UserDaoImpl();
        List<User> users = dao.getBlockedStudents();

        request.setAttribute("users", users);

        LOGGER.debug("Leaving doGet()");
        return Path.FORWARD_TO_VIEW_USERS_LIST;
    }

    @Override
    protected String doPost() {

        LOGGER.debug("Entering doPost()");

        Long studentId = Long.valueOf(request.getParameter("usr_id"));

        UserDao dao = new UserDaoImpl();
        User user = dao.get(studentId);
        if (user.getUserRole() == UserRole.STUDENT) {
            user.setBlocked(false);
            dao.update(user);
            LOGGER.trace("Unblocked user with id {}", user.getId());
        }

        List<User> list = dao.getStudents();
        request.setAttribute("users", list);

        LOGGER.debug("Leaving doPost()");

        return Path.REDIRECT_TO_VIEW_USERS_LIST;
    }
}
