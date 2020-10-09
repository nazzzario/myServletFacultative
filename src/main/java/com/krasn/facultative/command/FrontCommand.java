package com.krasn.facultative.command;

import com.krasn.facultative.util.ActionType;
import com.krasn.facultative.util.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class FrontCommand implements Command {

    private static final Logger LOGGER = LoggerFactory.getLogger(FrontCommand.class.getName());


    protected ServletContext context;
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected ActionType actionType;

    public void init(ServletContext context,
                     HttpServletRequest request,
                     HttpServletResponse response,
                     ActionType actionType) {
        this.context = context;
        this.request = request;
        this.response = response;
        this.actionType = actionType;
    }

    @Override
    public final String execute() throws ServletException, IOException {

        LOGGER.debug("Entering execute()");

        String path = null;

        if (actionType == null) {
            path = Path.WELCOME_PAGE;
        } else if (actionType == ActionType.GET) {
            path = doGet();
        } else if (actionType == ActionType.POST) {
            path = doPost();
        }

        LOGGER.debug("Leaving execute(): " + path);

        return path;
    }

    protected final void checkOnError() {

        if (request.getParameter("error") != null) {
            String error = request.getParameter("error");
            String lang = (String) request.getSession().getAttribute("lang");
            if (lang == null || lang.equals("en")) {
                if (error.equals("not_valid")) {
                    request.setAttribute("error_message", "Input values has failed validation. Try again.");
                }
            } else if (lang.equals("ru")) {
                if (error.equals("not_valid")) {
                    request.setAttribute("error_message", "Входные данных не прошли проверку. Попробуйте заново.");
                }
            }
        }
    }

    protected abstract String doGet();

    protected abstract String doPost();
}