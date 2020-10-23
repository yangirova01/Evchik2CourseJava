package ru.itis.servtets.repositories;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CookieRepositoryImpl implements CookieRepository {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/users";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "qwerty007";

    private HttpServletResponse response;
    private HttpServletRequest request;
    public UserRepositoryJdbcImpl repositoryJdbc;



    public CookieRepositoryImpl(HttpServletResponse response) {
        try {
            this.repositoryJdbc = new UserRepositoryJdbcImpl(
                    DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)
            );
            this.response = response;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
    CookieRepositoryImpl(HttpServletRequest request) {
        try {
            this.repositoryJdbc = new UserRepositoryJdbcImpl(
                    DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)
            );
            this.request = request;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void addCookie(String uuid, Integer id) {
        Cookie cookie = new Cookie("Auth", uuid);
        response.addCookie(cookie);
        repositoryJdbc.saveCookie(cookie, id, "uuid");
    }

    @Override
    public Cookie[] getCookie(String key) {
        return request.getCookies();
    }
}
