package com.basketleague.servlet;

import com.basketleague.service.PlayerService;
import com.basketleague.model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/players/cards")
public class PlayerCardsServlet extends HttpServlet {

    private final PlayerService service = new PlayerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        List<Player> players = service.getAll();

        req.setAttribute("players", players);

        req.getRequestDispatcher("/WEB-INF/views/player-cards.jsp")
                .forward(req, resp);
    }
}
