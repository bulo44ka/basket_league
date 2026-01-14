package com.basketleague.dao;

import com.basketleague.model.Match;
import java.util.List;
import java.util.Optional;

public interface MatchDao {

    List<Match> findAll();
    Optional<Match> findById(int id);
    void save(Match match);
    void update(Match match);
    void delete(int id);
}
