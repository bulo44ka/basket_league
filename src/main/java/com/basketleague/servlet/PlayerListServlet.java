package com.basketleague.servlet;

import com.basketleague.service.PlayerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/players")
public class PlayerListServlet extends HttpServlet {

    private final PlayerService playerService = new PlayerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("players", playerService.getAll());
        req.getRequestDispatcher("/WEB-INF/views/player-list.jsp")
                .forward(req, resp);
    }
}
