package com.java.intership.practice4.command.action;

import com.java.intership.practice4.command.Command;
import com.java.intership.practice4.command.CommandResult;
import com.java.intership.practice4.command.CommandType;
import com.java.intership.practice4.command.request.RequestManager;
import com.java.intership.practice4.command.request.Requests;
import com.java.intership.practice4.entity.User;
import com.java.intership.practice4.repository.UserRepository;

import javax.servlet.http.HttpServletResponse;

public class UserListPageCommand  implements Command {
    private static final String PAGE = "WEB-INF/views/userList.jsp";
    private static final String ERROR_PAGE = "WEB-INF/views/error.jsp";
    private static final String USER = "user";
    private static final String USER_LIST = "userList";
    private final UserRepository userRepository = UserRepository.INSTANCE;

    @Override
    public CommandResult execute(RequestManager manager, HttpServletResponse response) {
        Requests requestContext = manager.createContext();

        requestContext.addSessionAttribute(USER_LIST, userRepository.getAllUsers());
        manager.updateRequest(requestContext);
        return new CommandResult(PAGE, CommandType.FORWARD);
    }
}
