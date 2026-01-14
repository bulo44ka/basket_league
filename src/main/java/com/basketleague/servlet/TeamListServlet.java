package com.basketleague.servlet;

import com.basketleague.service.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/teams")
public class TeamListServlet extends HttpServlet {

    private final TeamService teamService = new TeamService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("teams", teamService.getAll());
        req.getRequestDispatcher("/WEB-INF/views/team-list.jsp").forward(req, resp);
    }
}
