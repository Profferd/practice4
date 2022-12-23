package com.java.intership.practice4;

import com.java.intership.practice4.command.Command;
import com.java.intership.practice4.command.CommandFactory;
import com.java.intership.practice4.command.CommandResult;
import com.java.intership.practice4.command.request.RequestManager;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class MainServlet extends HttpServlet {

    private static final String COMMAND = "command";
    private static final String PATH = "/practice4?";
    private static final String HOME = "command=home";

    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        process(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String commandName = request.getParameter(COMMAND);

        if (commandName == null || "".equals(commandName)) {
            response.sendRedirect(PATH + HOME);
        } else {
            Command command = CommandFactory.getInstance().getCommand(commandName);
            RequestManager manager = new RequestManager(request);

            CommandResult result = command.execute(manager, response);
            dispatch(result, request, response);
        }
    }

    private void dispatch(CommandResult result, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (result.isRedirect()) {
            response.sendRedirect(PATH + result.getPage());
        } else {
            request.getRequestDispatcher(result.getPage()).forward(request, response);
        }
    }

    public void destroy() {
        super.destroy();
    }
}