package com.basketleague.service;

import com.basketleague.dao.UserDao;
import com.basketleague.dao.impl.UserDaoJdbc;
import com.basketleague.model.User;

import java.util.Optional;

public class UserService {

    private final UserDao userDao = new UserDaoJdbc();

    public Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    public void register(User user) {
        userDao.save(user);
    }
}
