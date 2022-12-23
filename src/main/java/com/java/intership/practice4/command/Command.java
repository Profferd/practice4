package com.java.intership.practice4.command;

import com.java.intership.practice4.command.request.RequestManager;

import javax.servlet.http.HttpServletResponse;

public interface Command {

    CommandResult execute(RequestManager manager, HttpServletResponse response);

}

