package com.krasn.facultative.command;

import com.krasn.facultative.command.impl.AddStudentCommand;
import com.krasn.facultative.command.impl.LoginCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandInvoker.class.getName());

    private static final Map<String, CommandCreator> COMMANDS = new HashMap<>();

    static {
        COMMANDS.put("Login", LoginCommand::new);
        COMMANDS.put("AddStudent", AddStudentCommand::new);
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
