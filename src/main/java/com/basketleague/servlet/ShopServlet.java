package com.basketleague.servlet;

import com.basketleague.shop.ShopStorage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, javax.servlet.ServletException {

        req.setAttribute("items", ShopStorage.getAll());
        req.getRequestDispatcher("/WEB-INF/views/shop.jsp").forward(req, resp);
    }
}
