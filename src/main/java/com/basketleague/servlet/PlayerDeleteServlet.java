package com.basketleague.servlet;

import com.basketleague.service.PlayerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/players/delete")
public class PlayerDeleteServlet extends HttpServlet {

    private final PlayerService service = new PlayerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        service.delete(id);

        resp.sendRedirect("/players");
    }
}
