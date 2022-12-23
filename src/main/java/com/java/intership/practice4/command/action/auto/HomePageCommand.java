package com.java.intership.practice4.command.action.auto;

import com.java.intership.practice4.command.Command;
import com.java.intership.practice4.command.CommandResult;
import com.java.intership.practice4.command.CommandType;
import com.java.intership.practice4.command.request.RequestManager;
import com.java.intership.practice4.command.request.Requests;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class HomePageCommand implements Command {
    private static final String PAGE = "WEB-INF/views/home.jsp";

    /**
     * executing and show home page
     * @param manager
     * @param response
     * @return
     */
    @Override
    public CommandResult execute(RequestManager manager, HttpServletResponse response) {
        Requests requestContext = manager.createContext();
        manager.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandType.FORWARD);
    }
}
