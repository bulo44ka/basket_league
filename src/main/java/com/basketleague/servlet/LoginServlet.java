package com.basketleague.servlet;

import com.basketleague.model.User;
import com.basketleague.service.UserService;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Optional<User> userOpt = userService.findByUsername(username);

        if (userOpt.isPresent()) {

            User user = userOpt.get();

            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            resp.sendRedirect("/teams");
            return;
        }



        req.setAttribute("error", "Неверный логин или пароль");
        req.getRequestDispatcher("/WEB-INF/views/login.jsp")
                .forward(req, resp);
    }
}
