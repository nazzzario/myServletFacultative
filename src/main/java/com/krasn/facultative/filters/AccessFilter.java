package com.krasn.facultative.filters;

import com.krasn.facultative.domain.enums.UserRole;
import com.krasn.facultative.util.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class AccessFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccessFilter.class.getName());


    private Map<UserRole, List<String>> accessMap = new HashMap<>();
    private List<String> commons = new ArrayList<>();
    private List<String> outOfControl = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        LOGGER.debug("Entering access filter init.");

        accessMap.put(UserRole.ADMIN, asList(filterConfig.getInitParameter(UserRole.ADMIN.getName())));
        accessMap.put(UserRole.TEACHER, asList(filterConfig.getInitParameter(UserRole.TEACHER.getName())));
        accessMap.put(UserRole.STUDENT, asList(filterConfig.getInitParameter(UserRole.STUDENT.getName())));
        LOGGER.trace("Access map contains {} items.",accessMap.size());

        commons = asList(filterConfig.getInitParameter("common"));
        LOGGER.trace("Commons list contains {} items.", commons.size());

        outOfControl = asList(filterConfig.getInitParameter("out_of_control"));
        LOGGER.trace("Out of control list contains " + outOfControl.size() + " items.");

        LOGGER.debug("Leaving access filter init.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        LOGGER.debug("Entering doFilter()");

        if (isAllowed(servletRequest)) {
            LOGGER.debug("Filter finished");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String errorMessage = "You do not have permission to access the requested command!";
            servletRequest.setAttribute("error_message", errorMessage);
            LOGGER.trace("Set the request attribute: error_message = " + errorMessage);
            servletRequest.getRequestDispatcher(Path.ERROR_PAGE).forward(servletRequest, servletResponse);
        }

        LOGGER.debug("Leaving doFilter()");
    }

    private boolean isAllowed(ServletRequest _request) {

        HttpServletRequest request = (HttpServletRequest) _request;

        String command = request.getParameter("command");
        LOGGER.trace("Command: " + command);
        if (command == null || command.isEmpty()) {
            return false;
        }
        if (outOfControl.contains(command)) {
            return true;
        }
        HttpSession session = request.getSession(false);
        if (session == null) {
            return false;
        }
        UserRole role = (UserRole) session.getAttribute("user_role");
        if (role == null) {
            return commons.contains(command);
        }
        return accessMap.get(role).contains(command) || commons.contains(command);
    }

    private List<String> asList(String source) {
        List<String> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(source);
        while (st.hasMoreElements()) {
            list.add(st.nextToken());
        }
        return list;
    }

    @Override
    public void destroy( ) {

        /*NOP*/
    }
}
