package com.java.intership.practice4.command.action.auto;

import com.java.intership.practice4.command.Command;
import com.java.intership.practice4.command.CommandResult;
import com.java.intership.practice4.command.CommandType;
import com.java.intership.practice4.command.request.RequestManager;
import com.java.intership.practice4.command.request.Requests;
import com.java.intership.practice4.entity.User;
import com.java.intership.practice4.repository.UserRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements Command {

    private static final String HOME = "command=home";
    private static final String USER = "user";
    private static final String ERROR_PAGE = "WEB-INF/views/error.jsp";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String LOGIN_PARAMETER = "login";
    private static final String ERROR_MESSAGE = "error";
    private final UserRepository userRepository = UserRepository.INSTANCE;

    @Override
    public CommandResult execute(RequestManager manager, HttpServletResponse response) {
        Requests requestContext = manager.createContext();

        String password = requestContext.getRequestParameter(PASSWORD_PARAMETER);
        String login = requestContext.getRequestParameter(LOGIN_PARAMETER);

        User currentUser = userRepository.findUserByLogin(login);

        if (currentUser == null || !currentUser.getPassword().equals(password)) {
            requestContext.addRequestAttribute(ERROR_MESSAGE, true);
            manager.updateRequest(requestContext);
            return new CommandResult(ERROR_PAGE, CommandType.FORWARD);
        } else {
            requestContext.addSessionAttribute(USER, currentUser.getName());
            manager.updateRequest(requestContext);
            return new CommandResult(HOME, CommandType.REDIRECT);
        }

//        try {
//            UserService userService = new UserServiceImpl();
//            //password = DigestUtils.sha1Hex(password);
//            Optional<User> optionalResult = userService.login(login, password);
//            if (optionalResult.isPresent()) {
//                requestContext.addSessionAttribute(USER, optionalResult.get());
//                RoleService roleService = new RoleServiceImpl();
//                Optional<Role> role = roleService.findById(optionalResult.get().getRoleId());
//                role.ifPresent(value -> requestContext.addSessionAttribute(ROLE, value));
//                LOGGER.log(Level.INFO, "OK");
//                LOGGER.info("OK");
//                manager.updateRequest(requestContext);
//                return new CommandResult(HOME, CommandType.REDIRECT);
//            }
//        } catch (ServiceException e) {
//            return new CommandResult(ERROR_PAGE, CommandType.FORWARD);
//        }
    }
}
