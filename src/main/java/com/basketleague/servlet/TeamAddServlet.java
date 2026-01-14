package com.basketleague.servlet;

import com.basketleague.model.Team;
import com.basketleague.service.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/teams/add")
@MultipartConfig
public class TeamAddServlet extends HttpServlet {

    private final TeamService teamService = new TeamService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/views/team-form.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        String city = req.getParameter("city");

        Part logoPart = req.getPart("logo");
        String logoPath = null;

        if (logoPart != null && logoPart.getSize() > 0) {

            String fileName = Paths.get(logoPart.getSubmittedFileName())
                    .getFileName().toString();

            String uploadDir = getServletContext()
                    .getRealPath("/uploads/teams");

            File dir = new File(uploadDir);
            if (!dir.exists()) dir.mkdirs();

            String savedName = System.currentTimeMillis() + "_" + fileName;
            logoPart.write(uploadDir + File.separator + savedName);

            logoPath = "/uploads/teams/" + savedName;
        }

        Team team = new Team();
        team.setName(name);
        team.setCity(city);
        team.setLogo(logoPath);

        teamService.create(team);

        resp.sendRedirect("/teams");
    }
}
