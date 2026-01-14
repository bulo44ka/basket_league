package com.basketleague.servlet;

import com.basketleague.model.Player;
import com.basketleague.service.PlayerService;
import com.basketleague.service.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@MultipartConfig
@WebServlet("/players/edit")
public class PlayerEditServlet extends HttpServlet {

    private final PlayerService playerService = new PlayerService();
    private final TeamService teamService = new TeamService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Player player = playerService.getById(id);

        req.setAttribute("player", player);
        req.setAttribute("teams", teamService.getAll());

        req.getRequestDispatcher("/WEB-INF/views/player-edit.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));

        String name = req.getParameter("name");
        String position = req.getParameter("position");
        int teamId = Integer.parseInt(req.getParameter("teamId"));

        Integer height = req.getParameter("height").isEmpty()
                ? null
                : Integer.valueOf(req.getParameter("height"));

        Integer weight = req.getParameter("weight").isEmpty()
                ? null
                : Integer.valueOf(req.getParameter("weight"));

        String oldPhoto = req.getParameter("oldPhoto");

        Part filePart = req.getPart("photo");
        String fileName = null;

        if (filePart != null && filePart.getSize() > 0) {

            String uploadDir = getServletContext().getRealPath("/uploads");

            java.io.File dir = new java.io.File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            fileName = System.currentTimeMillis() + "_" + filePart.getSubmittedFileName();
            filePart.write(uploadDir + "/" + fileName);
        }

        Player p = new Player();
        p.setId(id);
        p.setName(name);
        p.setPosition(position);
        p.setTeamId(teamId);
        p.setHeight(height);
        p.setWeight(weight);

        p.setPhoto(fileName != null ? "/uploads/" + fileName : oldPhoto);

        playerService.update(p);

        resp.sendRedirect("/players");
    }
}
