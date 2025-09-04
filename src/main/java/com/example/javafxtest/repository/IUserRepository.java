package com.example.javafxtest.repository;

import com.example.javafxtest.model.User;

import java.util.List;

public interface IUserRepository {
    void createUser(String name, String email, String password);
    void updateUser(String name, String email, String password);
    void deleteUser(String email);
    List<User> sowAllUsers();
    User showUserByEmail(String email);
}
