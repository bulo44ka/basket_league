package com.basketleague.listener;

import com.basketleague.util.DbManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        // 🔥 ВАЖНО: инициализация БД
        DbManager.init(sce.getServletContext());

        System.out.println("BasketLeague started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("BasketLeague stopped");
    }
}
