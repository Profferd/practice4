package com.java.intership.practice4.repository;

import com.java.intership.practice4.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public static final UserRepository INSTANCE = new UserRepository();
    public final List<User> users;

    private UserRepository() {
        users = new ArrayList<>();
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User findUserByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public void putUser(User user) {
        users.add(user);
    }
}
