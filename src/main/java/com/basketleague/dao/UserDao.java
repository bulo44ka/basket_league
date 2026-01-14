package com.basketleague.dao;

import com.basketleague.model.User;
import java.util.Optional;

public interface UserDao {
    Optional<User> findByUsername(String username);
    void save(User user);
}
