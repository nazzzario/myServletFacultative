package com.krasn.facultative.command.impl;

import com.krasn.facultative.command.FrontCommand;
import com.krasn.facultative.dao.entity.UserDao;
import com.krasn.facultative.dao.entity.impl.UserDaoImpl;
import com.krasn.facultative.domain.enums.UserRole;
import com.krasn.facultative.domain.entity.User;
import com.krasn.facultative.util.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand extends FrontCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginCommand.class.getName());

    @Override
    protected String doGet() {
        return Path.FORWARD_TO_LOGIN_FORM;
    }

    @Override
    protected String doPost() {
        LOGGER.debug("Entering doPost()");

        String path = null;

        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        LOGGER.trace("on doPost() login = {}; password = {}", login , password);

        UserDao dao = new UserDaoImpl();
        User user = dao.getByLogin(login);


        if (user == null) {

            String enErrMsg = "Incorrect login.";
            String uaErrMsg = "Incorrect login.";
            setErrorMessage(enErrMsg, uaErrMsg, request);
            LOGGER.trace("User with login {} is not found." ,login);
        } else if (!password.equals(user.getPassword())) {

            String enErrMsg = "Incorrect password.";
            String uaErrMsg = "Incorrect password.";
            setErrorMessage(enErrMsg, uaErrMsg, request);
            LOGGER.trace("Password {} is wrong.", password);
        } else if (user.isBlocked()) {

            String enErrMsg = "Your account is blocked.";
            String uaErrMsg = "Your account is blocked.";
            setErrorMessage(enErrMsg, uaErrMsg, request);
            LOGGER.trace("User is blocked.");
        } else if (user.getUserRole() != UserRole.TEACHER) {

            LOGGER.trace("on doPost() user with id {}",user.getId());
            UserRole role = user.getUserRole();
            path = Path.WELCOME_PAGE;
            session.setAttribute("user", user);
            session.setAttribute("user_role", role);
        }
//        else {
//            LOGGER.trace("on doPost() user with id {}", user.getId());
//            UserRole role = user.getUserRole();
//            path = Path.WELCOME_PAGE;
//            session.setAttribute("user", user);
//            session.setAttribute("user_permission", role);
//        }

        LOGGER.debug("Leaving doPost() {} ",path);
        return path;
    }

    private void setErrorMessage(String enErrMsg, String uaErrMsg, HttpServletRequest request) {

        String lang = (String) request.getSession().getAttribute("lang");
        String errorMessage = "";
        if (lang == null || lang.equals("en")) {
            errorMessage = enErrMsg;
        } else if (lang.equals("ua")) {
            errorMessage = uaErrMsg;
        }
        request.getSession().setAttribute("error", errorMessage);
        LOGGER.error("errorMessage: {}",errorMessage);
    }
}

