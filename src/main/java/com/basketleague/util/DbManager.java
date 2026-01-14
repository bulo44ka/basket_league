package com.basketleague.util;

import javax.servlet.ServletContext;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {

    private static String url;
    private static String user;
    private static String password;

    public static void init(ServletContext context) {
        try (InputStream is = context.getResourceAsStream("/WEB-INF/db.properties")) {
            Properties props = new Properties();
            props.load(is);

            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
            password = props.getProperty("db.password");

            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            throw new RuntimeException("DB init error", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close() {
        // можно закрывать connection pool, если появится
    }
}
