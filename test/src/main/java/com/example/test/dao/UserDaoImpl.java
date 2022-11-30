package com.example.test.dao;

import com.example.test.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
    }

    public List<User> getAllUsers() {
        return this.entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public void createUser(User user) {
        this.entityManager.persist(user);
        this.entityManager.flush();
    }

    public void updateUser(User user) {
        this.entityManager.merge(user);
        this.entityManager.flush();
    }

    public User readUser(long id) {
        return this.entityManager.find(User.class, id);
    }

    public User deleteUser(long id) throws NullPointerException {
        User user = this.readUser(id);
        if (null == user) {
            throw new NullPointerException("User not found");
        } else {
            this.entityManager.remove(user);
            this.entityManager.flush();
            return user;
        }
    }
}
