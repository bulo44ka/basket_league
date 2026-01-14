package com.basketleague.servlet;

import com.basketleague.service.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/ajax/check-username")
public class CheckUsernameServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String username = req.getParameter("username");

        boolean exists = userService.findByUsername(username).isPresent();

        resp.setContentType("application/json");
        resp.getWriter().write("{\"exists\": " + exists + "}");
    }
}
