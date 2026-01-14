package com.basketleague.servlet;

import com.basketleague.model.Match;
import com.basketleague.service.MatchService;
import com.basketleague.service.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/matches/add")
public class MatchFormServlet extends HttpServlet {

    private final MatchService matchService = new MatchService();
    private final TeamService teamService = new TeamService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("teams", teamService.getAll());
        req.getRequestDispatcher("/WEB-INF/views/match-form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        try {
            Match m = new Match();
            m.setTeamHomeId(Integer.parseInt(req.getParameter("teamHomeId")));
            m.setTeamAwayId(Integer.parseInt(req.getParameter("teamAwayId")));
            m.setMatchDate(LocalDateTime.parse(req.getParameter("date")));
            m.setStatus(req.getParameter("status"));

            if ("FINISHED".equals(m.getStatus())) {
                m.setHomeScore(Integer.parseInt(req.getParameter("homeScore")));
                m.setAwayScore(Integer.parseInt(req.getParameter("awayScore")));
            }

            matchService.save(m);
            resp.sendRedirect("/matches");

        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
            doGet(req, resp);
        }
    }
}
