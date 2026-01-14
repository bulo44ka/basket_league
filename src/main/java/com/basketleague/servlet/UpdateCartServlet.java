package com.basketleague.servlet;

import com.basketleague.shop.CartUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cart/update")
public class UpdateCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int qty = Integer.parseInt(req.getParameter("qty"));
        CartUtils.update(req.getSession(), id, qty);
        resp.sendRedirect("/cart");
    }
}
