package com.krasn.facultative.command.impl;

import com.krasn.facultative.command.FrontCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LanguageCommand extends FrontCommand {

    private static final Logger LOGGER = LoggerFactory.getLogger(LanguageCommand.class.getName());


    @Override
    protected String doGet( ) {
        return doPost();
    }

    @Override
    protected String doPost( ) {

        String action = "controller?";

        String url = request.getParameter("url");
        String lang = request.getParameter("language");
        LOGGER.trace("url: {}, language: {}", url ,lang);

        request.getSession().setAttribute("lang", lang);
        LOGGER.trace("Language has been changed to {}", lang);

        if (url.equals("command=logout") || url.isEmpty()) {
            return null;
        }

        return action + url;
    }
}
