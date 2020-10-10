package com.krasn.facultative.command.impl;

import com.krasn.facultative.command.FrontCommand;
import com.krasn.facultative.util.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;

public class LogoutCommand extends FrontCommand {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogoutCommand.class.getName());

    @Override
    protected String doGet() {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return Path.WELCOME_PAGE;
    }

    @Override
    protected String doPost() {
        return doGet();
    }
}
