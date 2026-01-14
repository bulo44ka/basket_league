package com.basketleague.dao.impl;

import com.basketleague.dao.PlayerDao;
import com.basketleague.model.Player;
import com.basketleague.util.DbManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlayerDaoJdbc implements PlayerDao {

    @Override
    public List<Player> findAll() {
        List<Player> list = new ArrayList<>();
        String sql = "select * from player";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Player(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("position"),
                        rs.getInt("team_id"),
                        (Integer) rs.getObject("height"),
                        (Integer) rs.getObject("weight"),
                        rs.getString("photo")
                ));


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public List<Player> findByTeam(int teamId) {
        List<Player> list = new ArrayList<>();
        String sql = "select * from player where team_id = ?";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, teamId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Player(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("position"),
                            rs.getInt("team_id"),
                            (Integer) rs.getObject("height"),
                            (Integer) rs.getObject("weight"),
                            rs.getString("photo")
                    ));

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void save(Player player) {
        String sql =
                "insert into player(name, position, team_id, height, weight, photo) " +
                "values (?, ?, ?, ?, ?, ?)";


        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, player.getName());
            ps.setString(2, player.getPosition());
            ps.setInt(3, player.getTeamId());
            ps.setObject(4, player.getHeight());
            ps.setObject(5, player.getWeight());
            ps.setString(6, player.getPhoto());



            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int count() {

        String sql = "select count(*) from player";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) return rs.getInt(1);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return 0;
    }


    @Override
    public Optional<Player> findById(int id) {

        String sql = "select * from player where id = ?";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    Player p = new Player(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("position"),
                            rs.getInt("team_id"),
                            (Integer) rs.getObject("height"),
                            (Integer) rs.getObject("weight"),
                            rs.getString("photo")
                    );

                    return Optional.of(p);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    @Override
    public List<Player> findByTeamId(int teamId) {

        List<Player> list = new ArrayList<>();

        String sql = "select * from player where team_id = ?";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, teamId);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    Player p = new Player(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("position"),
                            rs.getInt("team_id"),
                            (Integer) rs.getObject("height"),
                            (Integer) rs.getObject("weight"),
                            rs.getString("photo")
                    );

                    list.add(p);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }


    @Override
    public void update(Player player) {

        String sql = "update player set name=?, position=?, team_id=?, height=?, weight=?, photo=? " +
                "where id=?";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, player.getName());
            ps.setString(2, player.getPosition());
            ps.setInt(3, player.getTeamId());
            ps.setObject(4, player.getHeight());
            ps.setObject(5, player.getWeight());
            ps.setString(6, player.getPhoto());
            ps.setInt(7, player.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void delete(int id) {
        String sql = "delete from player where id = ?";

        try (Connection conn = DbManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
