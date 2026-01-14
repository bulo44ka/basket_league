package com.basketleague.servlet;

import com.basketleague.model.Player;
import com.basketleague.service.PlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/players/search")
public class SearchPlayerServlet extends HttpServlet {

    private final PlayerService service = new PlayerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String q = req.getParameter("q");
        String query = (q == null) ? "" : q;

        List<Player> all = service.getAll();

        List<Player> filtered =
                all.stream()
                        .filter(p -> p.getName() != null &&
                                p.getName().toLowerCase()
                                        .contains(query.toLowerCase()))
                        .collect(Collectors.toList());

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getWriter(), filtered);
    }
}
