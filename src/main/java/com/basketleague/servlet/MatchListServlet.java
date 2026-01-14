package com.basketleague.servlet;

import com.basketleague.model.Team;
import com.basketleague.service.MatchService;
import com.basketleague.service.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/matches")
public class MatchListServlet extends HttpServlet {

    private final MatchService matchService = new MatchService();
    private final TeamService teamService = new TeamService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("matches", matchService.getAll());

        Map<Integer, Team> teamMap = teamService.getAll().stream()
                .collect(Collectors.toMap(Team::getId, t -> t));

        req.setAttribute("teamMap", teamMap);

        req.getRequestDispatcher("/WEB-INF/views/match-list.jsp")
                .forward(req, resp);
    }
}
