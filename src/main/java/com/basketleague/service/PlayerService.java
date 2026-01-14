package com.basketleague.service;

import com.basketleague.dao.PlayerDao;
import com.basketleague.dao.impl.PlayerDaoJdbc;
import com.basketleague.model.Player;

import java.util.List;

public class PlayerService {

    private final PlayerDao dao = new PlayerDaoJdbc();

    public List<Player> getAll() {
        return dao.findAll();
    }

    public void create(Player player) {
        dao.save(player);
    }

    public void update(Player player) {
        dao.update(player);
    }

    public Player getById(int id) {
        return dao.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found: " + id));
    }

    public int count() {
        return dao.count();
    }


    public void delete(int id) {
        dao.delete(id);
    }

    public List<Player> findByTeam(int teamId) {
        return dao.findByTeamId(teamId);
    }


}
