package com.basketleague.servlet;

import com.basketleague.model.Team;
import com.basketleague.model.Player;
import com.basketleague.service.TeamService;
import com.basketleague.service.PlayerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/teams/players")
public class TeamPlayersServlet extends HttpServlet {

    private final TeamService teamService = new TeamService();
    private final PlayerService playerService = new PlayerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Team team = teamService.getById(id);
        List<Player> players = playerService.findByTeam(id);

        req.setAttribute("team", team);
        req.setAttribute("players", players);

        req.getRequestDispatcher("/WEB-INF/views/team-players.jsp")
                .forward(req, resp);
    }
}
