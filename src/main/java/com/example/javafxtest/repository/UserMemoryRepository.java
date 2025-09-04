package com.example.javafxtest.repository;

import com.example.javafxtest.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMemoryRepository implements IUserRepository {
    List<User> users;

    public UserMemoryRepository() {
        this.users = new ArrayList<>();
    }

    @Override
    public void createUser(String name, String email, String password) {
        this.users.add(new User(name, email, password));
    }

    @Override
    public void updateUser(String name, String email, String password) {
        User user = showUserByEmail(email);
        if (user != null) {
            user.setName(name);
            user.setPassword(password);
        }
    }

    @Override
    public void deleteUser(String email) {
        this.users.removeIf(user -> user.getEmail().equals(email));
    }

    @Override
    public List<User> sowAllUsers() {
        return this.users;
    }

    @Override
    public User showUserByEmail(String email) {
        return this.users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }
}
