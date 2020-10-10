package com.krasn.facultative.command.impl;

import com.krasn.facultative.command.FrontCommand;
import com.krasn.facultative.dao.entity.UserDao;
import com.krasn.facultative.dao.entity.impl.UserDaoImpl;
import com.krasn.facultative.domain.entity.User;
import com.krasn.facultative.util.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ListUsersCommand extends FrontCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListUsersCommand.class.getName());

    //todo fix
    @Override
    protected String doGet() {

        LOGGER.debug("Entering doGet()");

        UserDao dao = new UserDaoImpl();
        List<User> students = dao.getStudents();
        List<User> teachers = dao.getTeachers();

        request.setAttribute("students",students );
        request.setAttribute("teachers",teachers );
        LOGGER.trace("Students list contains {} items.",students.size());
        LOGGER.trace("Teachers list contains {} items.",teachers.size());

        LOGGER.debug("Leaving doGet()");
        return Path.FORWARD_TO_VIEW_USERS_LIST;
    }

    @Override
    protected String doPost() {
        return Path.REDIRECT_TO_VIEW_USERS_LIST;
    }
}
