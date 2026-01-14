package com.basketleague.dao;

import com.basketleague.model.Team;
import java.util.List;
import java.util.Optional;

public interface TeamDao {
    List<Team> findAll();
    Optional<Team> findById(int id);
    void save(Team team);
    void update(Team team);
    void delete(int id);
    int count();

}

