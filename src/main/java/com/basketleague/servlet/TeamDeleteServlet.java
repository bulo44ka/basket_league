package com.basketleague.servlet;

import com.basketleague.service.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/teams/delete")
public class TeamDeleteServlet extends HttpServlet {

    private final TeamService service = new TeamService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        try {
            service.delete(id);
            resp.sendRedirect("/teams");

        } catch (RuntimeException e) {

            req.setAttribute(
                    "error",
                    "Нельзя удалить команду — в ней есть игроки"
            );

            req.setAttribute("teams", service.getAll());

            req.getRequestDispatcher("/WEB-INF/views/team-list.jsp")
                    .forward(req, resp);
        }
    }
}
