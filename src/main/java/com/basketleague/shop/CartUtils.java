package com.basketleague.shop;

import javax.servlet.http.HttpSession;
import java.util.*;

public class CartUtils {

    @SuppressWarnings("unchecked")
    public static List<CartItem> getCart(HttpSession session) {
        List<CartItem> cart = (List<CartItem>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }
        return cart;
    }

    public static void add(HttpSession session, int itemId) {
        List<CartItem> cart = getCart(session);

        for (CartItem c : cart) {
            if (c.getItem().getId() == itemId) {
                c.setQuantity(c.getQuantity() + 1);
                return;
            }
        }

        cart.add(new CartItem(ShopStorage.getById(itemId), 1));
    }

    public static void update(HttpSession session, int itemId, int qty) {
        getCart(session).forEach(c -> {
            if (c.getItem().getId() == itemId) c.setQuantity(qty);
        });
    }

    public static void clear(HttpSession session) {
        getCart(session).clear();
    }
}
