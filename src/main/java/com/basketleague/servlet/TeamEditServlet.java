package com.basketleague.servlet;

import com.basketleague.model.Team;
import com.basketleague.service.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/teams/edit")
public class TeamEditServlet extends HttpServlet {

    private final TeamService teamService = new TeamService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Team team = teamService.getById(id);

        req.setAttribute("team", team);
        req.getRequestDispatcher("/WEB-INF/views/team-edit.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String city = req.getParameter("city");
        String logo = req.getParameter("logo");

        Team team = new Team(id, name, city,logo);

        teamService.update(team);

        resp.sendRedirect("/teams");
    }
}
