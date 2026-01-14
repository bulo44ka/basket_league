package com.basketleague.servlet;

import com.basketleague.service.PlayerService;
import com.basketleague.service.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    private final TeamService teamService = new TeamService();
    private final PlayerService playerService = new PlayerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("teamsCount", teamService.count());
        req.setAttribute("playersCount", playerService.count());

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
