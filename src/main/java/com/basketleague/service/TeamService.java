package com.basketleague.service;

import com.basketleague.dao.TeamDao;
import com.basketleague.dao.impl.TeamDaoJdbc;
import com.basketleague.model.Team;

import java.util.List;

public class TeamService {

    private final TeamDao teamDao = new TeamDaoJdbc();

    public List<Team> getAll() {
        return teamDao.findAll();
    }

    public Team getById(int id) {
        return teamDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found"));
    }

    public void create(Team team) {
        teamDao.save(team);
    }

    public void update(Team team) {
        teamDao.update(team);
    }

    public void delete(int id) {
        teamDao.delete(id);
    }

    public int count() {
        return teamDao.count();
    }


}
