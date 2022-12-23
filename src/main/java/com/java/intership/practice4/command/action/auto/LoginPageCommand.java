package com.java.intership.practice4.command.action.auto;

import com.java.intership.practice4.command.Command;
import com.java.intership.practice4.command.CommandResult;
import com.java.intership.practice4.command.CommandType;
import com.java.intership.practice4.command.request.RequestManager;
import com.java.intership.practice4.command.request.Requests;

import javax.servlet.http.HttpServletResponse;

public class LoginPageCommand implements Command {
    private static final String PAGE = "WEB-INF/views/login.jsp";
    /**
     * executing and show log in page
     * @param manager
     * @param response
     * @return command result
     */
    @Override
    public CommandResult execute(RequestManager manager, HttpServletResponse response) {
        Requests requestContext = manager.createContext();
        manager.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandType.FORWARD);
    }
}
