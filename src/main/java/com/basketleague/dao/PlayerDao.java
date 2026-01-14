package com.basketleague.dao;

import com.basketleague.model.Player;
import java.util.List;
import java.util.Optional;

public interface PlayerDao {
    List<Player> findAll();
    List<Player> findByTeam(int teamId);
    void save(Player player);
    void delete(int id);
    void update(Player player);
    Optional<Player> findById(int id);
    int count();
    List<Player> findByTeamId(int teamId);

}
