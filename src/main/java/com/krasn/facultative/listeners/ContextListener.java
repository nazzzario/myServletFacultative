package com.krasn.facultative.listeners;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContextListener.class.getName());


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        log("Entering context initialization.");

        ServletContext context = servletContextEvent.getServletContext();
        initLogger(context);

        log("Leaving context initialization.");
    }

    private void initLogger(ServletContext context) {

        log("Entering init logger.");

        try {
            PropertyConfigurator.configure(context.getRealPath("WEB-INF/log4j.properties")
            );
            LOGGER.debug("Logger has been initialized.");
        } catch (Exception e) {
            log("Cannot initialize Logger");
            e.printStackTrace();
        }

        log("Leaving init logger.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        /*NOP*/
    }

    private void log(String message) {
        System.out.println("[ContextListener] : " + message);
    }
}