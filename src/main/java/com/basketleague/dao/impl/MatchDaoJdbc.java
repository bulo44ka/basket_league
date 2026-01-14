package com.basketleague.dao.impl;

import com.basketleague.dao.MatchDao;
import com.basketleague.model.Match;
import com.basketleague.util.DbManager;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MatchDaoJdbc implements MatchDao {

    @Override
    public List<Match> findAll() {

        List<Match> list = new ArrayList<>();

        String sql = "SELECT * FROM \"match\" ORDER BY match_date";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Match m = new Match(
                        rs.getInt("id"),
                        rs.getInt("team_home_id"),
                        rs.getInt("team_away_id"),
                        rs.getTimestamp("match_date").toLocalDateTime(),
                        rs.getString("status"),
                        (Integer) rs.getObject("home_score"),
                        (Integer) rs.getObject("away_score")
                );

                list.add(m);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public Optional<Match> findById(int id) {

        String sql = "SELECT * FROM \"match\" WHERE id = ?";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    Match m = new Match(
                            rs.getInt("id"),
                            rs.getInt("team_home_id"),
                            rs.getInt("team_away_id"),
                            rs.getTimestamp("match_date").toLocalDateTime(),
                            rs.getString("status"),
                            (Integer) rs.getObject("home_score"),
                            (Integer) rs.getObject("away_score")
                    );

                    return Optional.of(m);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public void save(Match m) {

        String sql = """
                INSERT INTO "match"
                (team_home_id, team_away_id, match_date, status, home_score, away_score)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, m.getTeamHomeId());
            ps.setInt(2, m.getTeamAwayId());
            ps.setTimestamp(3, Timestamp.valueOf(m.getMatchDate()));
            ps.setString(4, m.getStatus());
            ps.setObject(5, m.getHomeScore());
            ps.setObject(6, m.getAwayScore());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Match m) {

        String sql = """
                UPDATE "match"
                SET team_home_id = ?,
                    team_away_id = ?,
                    match_date = ?,
                    status = ?,
                    home_score = ?,
                    away_score = ?
                WHERE id = ?
                """;

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, m.getTeamHomeId());
            ps.setInt(2, m.getTeamAwayId());
            ps.setTimestamp(3, Timestamp.valueOf(m.getMatchDate()));
            ps.setString(4, m.getStatus());
            ps.setObject(5, m.getHomeScore());
            ps.setObject(6, m.getAwayScore());
            ps.setInt(7, m.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {

        String sql = "DELETE FROM \"match\" WHERE id = ?";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
