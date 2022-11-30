package com.example.test.dao;

import com.example.test.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {
    List<User> getAllUsers();

    void createUser(User var1);

    void updateUser(User var1);

    User readUser(long var1);

    User deleteUser(long var1);
}

