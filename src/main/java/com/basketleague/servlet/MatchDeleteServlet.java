package com.basketleague.servlet;

import com.basketleague.service.MatchService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/matches/delete")
public class MatchDeleteServlet extends HttpServlet {

    private final MatchService matchService = new MatchService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        matchService.delete(id);
        resp.sendRedirect("/matches");
    }
}
