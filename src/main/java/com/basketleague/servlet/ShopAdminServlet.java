package com.basketleague.servlet;

import com.basketleague.shop.ShopStorage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/shop/admin")
public class ShopAdminServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String name = req.getParameter("name");
        String image = req.getParameter("image");

        int price = Integer.parseInt(req.getParameter("price")); // ← int, а не double

        ShopStorage.add(name, image, price);

        resp.sendRedirect("/shop");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        String deleteId = req.getParameter("delete");

        if (deleteId != null) {
            ShopStorage.delete(Integer.parseInt(deleteId));
        }

        resp.sendRedirect("/shop");
    }
}
