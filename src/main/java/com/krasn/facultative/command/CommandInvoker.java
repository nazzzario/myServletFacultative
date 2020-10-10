package com.krasn.facultative.command;

import com.krasn.facultative.command.impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {

    private CommandInvoker() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandInvoker.class.getName());

    private static final Map<String, CommandCreator> COMMANDS = new HashMap<>();

    static {
        COMMANDS.put("login", LoginCommand::new);
        COMMANDS.put("logout", LogoutCommand::new );
        COMMANDS.put("language", LanguageCommand::new);
        COMMANDS.put("add-student", AddStudentCommand::new);
        COMMANDS.put("add-teacher", AddTeacherCommand::new);


        COMMANDS.put("add-course", AddCourseCommand::new );
        COMMANDS.put("list-courses", ListCoursesCommand::new);
        COMMANDS.put("edit-course", EditCourseCommand::new);

        COMMANDS.put("list-users",ListUsersCommand::new);
        COMMANDS.put("block-student",BlockStudentCommand::new);
        COMMANDS.put("unblock-student", UnblockStudentCommand::new);
    }

    public static FrontCommand getCommand(String commandName) {

        LOGGER.debug("Entering getCommand(commandName = {} )",commandName);

        FrontCommand command;
        if (commandName == null) {
            LOGGER.warn("getCommand() input value is null.");
            command = COMMANDS.get("UnknownCommand").create();
        } else if (!COMMANDS.containsKey(commandName)) {
            LOGGER.warn("getCommand() cannot find command with such name: {}", commandName);
            command = COMMANDS.get("UnknownCommand").create();
        } else {
            command = COMMANDS.get(commandName).create();
        }

        LOGGER.debug("Leaving getCommand(): {}", command.getClass());
        return command;
    }
}
