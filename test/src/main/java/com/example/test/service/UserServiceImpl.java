package com.example.test.service;

import com.example.test.dao.UserDao;
import com.example.test.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserDao UD;


    public UserServiceImpl(@Qualifier("userDaoImpl") UserDao ud) {
        UD = ud;
    }

    public List<User> getAllUsers() {
        return this.UD.getAllUsers();
    }

    public void createUser(User user) {
        this.UD.createUser(user);
    }

    public void updateUser(User user) {
        this.UD.updateUser(user);
    }

    public User readUser(long id) {
        return this.UD.readUser(id);
    }

    public User deleteUser(long id) {
        User user = null;

        try {
            user = this.UD.deleteUser(id);
        } catch (NullPointerException var5) {
            var5.printStackTrace();
        }

        return user;
    }
}
