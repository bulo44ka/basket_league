package com.basketleague.servlet;

import com.basketleague.model.Player;
import com.basketleague.service.PlayerService;
import com.basketleague.service.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/players/add")
@MultipartConfig
public class PlayerAddServlet extends HttpServlet {

    private final PlayerService playerService = new PlayerService();
    private final TeamService teamService = new TeamService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // ⬅️ ВАЖНО: передаём команды в форму
        req.setAttribute("teams", teamService.getAll());

        req.getRequestDispatcher("/WEB-INF/views/player-form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");

        if (name == null || name.isBlank()) {
            req.setAttribute("errorMessage", "Имя игрока не заполнено");
            req.getRequestDispatcher("/WEB-INF/views/error.jsp")
                    .forward(req, resp);
            return;
        }
        String position = req.getParameter("position");
        int height = Integer.parseInt(req.getParameter("height"));
        int weight = Integer.parseInt(req.getParameter("weight"));

        // ✅ ЧИТАЕМ КОМАНДУ
        int teamId = Integer.parseInt(req.getParameter("teamId"));

        Part photoPart = req.getPart("photo");
        String photoPath = null;

        if (photoPart != null && photoPart.getSize() > 0) {

            String fileName = Paths.get(photoPart.getSubmittedFileName())
                    .getFileName().toString();

            String uploadDir = getServletContext()
                    .getRealPath("/uploads/players");

            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String savedName = System.currentTimeMillis() + "_" + fileName;
            photoPart.write(uploadDir + File.separator + savedName);

            photoPath = "/uploads/players/" + savedName;
        }

        Player player = new Player();
        player.setName(name);
        player.setPosition(position);
        player.setHeight(height);
        player.setWeight(weight);
        player.setTeamId(teamId); // ⬅️ КЛЮЧЕВО
        player.setPhoto(photoPath);

        playerService.create(player);

        resp.sendRedirect("/players");
    }
}
