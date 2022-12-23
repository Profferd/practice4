package com.java.intership.practice4.command.action.auto;

import com.java.intership.practice4.command.Command;
import com.java.intership.practice4.command.CommandResult;
import com.java.intership.practice4.command.CommandType;
import com.java.intership.practice4.command.request.RequestManager;
import com.java.intership.practice4.command.request.Requests;

import javax.servlet.http.HttpServletResponse;

public class LogoutCommand implements Command {
    private static final String LOGIN = "command=login";
    private static final String USER = "user";

    /**
     * Executing and remove user from session
     * @param manager
     * @param response
     * @return command result
     */
    @Override
    public CommandResult execute(RequestManager manager, HttpServletResponse response) {
        Requests requests = manager.createContext();
        requests.removeSessionAttribute(USER);
        manager.updateRequest(requests);
        return new CommandResult(LOGIN, CommandType.REDIRECT);
    }
}
