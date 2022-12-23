package com.java.intership.practice4.command;

import com.java.intership.practice4.command.action.UserListPageCommand;
import com.java.intership.practice4.command.action.auto.HomePageCommand;
import com.java.intership.practice4.command.action.auto.LoginCommand;
import com.java.intership.practice4.command.action.auto.LoginPageCommand;
import com.java.intership.practice4.command.action.auto.LogoutCommand;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CommandFactory {
    private static final Map<String, Command> commands = new HashMap<>();

    private CommandFactory() {
        commands.put(CommandName.LOG_IN_COMMAND, new LoginPageCommand());
        commands.put(CommandName.HOME_COMMAND, new HomePageCommand());
        commands.put(CommandName.CHECK_LOGIN_COMMAND, new LoginCommand());
        commands.put(CommandName.LOG_OUT_COMMAND, new LogoutCommand());
        commands.put(CommandName.USER_LIST_COMMAND, new UserListPageCommand());
    }

    public static CommandFactory getInstance() {
        return Holder.INSTANCE;
    }

    public Command getCommand(String name) {
        return Optional.ofNullable(commands.get(name)).orElse(commands.get(CommandName.DEFAULT_COMMAND));
    }

    private static class Holder {
        static final CommandFactory INSTANCE = new CommandFactory();
    }
}
