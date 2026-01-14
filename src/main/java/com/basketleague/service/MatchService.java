package com.basketleague.service;

import com.basketleague.dao.impl.MatchDaoJdbc;
import com.basketleague.model.Match;

import java.util.List;
import java.util.Optional;

public class MatchService {

    private final MatchDaoJdbc dao = new MatchDaoJdbc();

    public List<Match> getAll() {
        return dao.findAll();
    }

    public Optional<Match> getById(int id) {
        return dao.findById(id);
    }

    public void save(Match m) {

        if (m.getTeamHomeId() == m.getTeamAwayId()) {
            throw new RuntimeException("Команды не могут совпадать");
        }

        if ("PLANNED".equals(m.getStatus())) {
            m.setHomeScore(null);
            m.setAwayScore(null);
        }

        if ("FINISHED".equals(m.getStatus())) {
            if (m.getHomeScore() == null || m.getAwayScore() == null) {
                throw new RuntimeException("Для завершенного матча нужен счет");
            }
        }

        dao.save(m);
    }

    public void update(Match match) {
        dao.update(match);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
