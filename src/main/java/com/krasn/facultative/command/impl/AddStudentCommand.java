package com.krasn.facultative.command.impl;

import com.krasn.facultative.command.FrontCommand;
import com.krasn.facultative.dao.entity.UserDao;
import com.krasn.facultative.dao.entity.impl.UserDaoImpl;
import com.krasn.facultative.domain.enums.UserRole;
import com.krasn.facultative.domain.entity.User;
import com.krasn.facultative.util.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddStudentCommand extends FrontCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(AddStudentCommand.class.getName());

    @Override
    protected String doGet() {
        LOGGER.debug("Entering doGet()");

        checkOnError();

        String desiredPermission = request.getParameter("desired_permission");

        request.setAttribute("desired_permission", desiredPermission);


        LOGGER.debug("Leaving doGet()");
        return Path.FORWARD_TO_ADD_STUDENT_FORM;
    }

    @Override
    protected String doPost() {

        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");

//        boolean valid = UserInputValidator.validate();

        if (true) {
            LOGGER.trace("Fields: {}, {}, {}, {}", login, password,firstName, lastName);

            User user = new User();
            user.setLogin(login);
            user.setPassword(password);
            user.setUserRole(UserRole.STUDENT);
            user.setFirstName(firstName);
            user.setLastName(lastName);

            UserDao dao = new UserDaoImpl();
            user = dao.create(user);
            request.setAttribute("user", user);

            LOGGER.trace("The student with id {} added." , user.getId() );
        } else {
            LOGGER.trace("Fields failed validation.");
            return Path.REDIRECT_TO_ADD_STUDENT_FORM + "&error=not_valid";
        }

        LOGGER.debug("Leaving doPost()");
        return Path.REDIRECT_TO_LOGIN_FORM;
    }
}
