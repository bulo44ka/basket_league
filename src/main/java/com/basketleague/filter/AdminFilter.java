package com.basketleague.filter;

import com.basketleague.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@WebFilter({
        "/teams/add",
        "/teams/edit",
        "/teams/delete",
        "/players/add",
        "/players/edit",
        "/players/delete",
        "/shop/admin",
        "/matches/add",
        "/matches/edit",
        "/matches/delete"
})

public class AdminFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        User user = (session != null)
                ? (User) session.getAttribute("user")
                : null;

        if (user == null || !"ADMIN".equals(user.getRole())) {

            resp.sendRedirect("/login");
            return;
        }

        chain.doFilter(request, response);
    }
}
