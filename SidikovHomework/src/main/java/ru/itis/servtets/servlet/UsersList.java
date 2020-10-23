package ru.itis.servtets.servlet;

import ru.itis.servtets.model.User;
import ru.itis.servtets.repositories.UserRepositoryJdbcImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/users")
public class UsersList extends HttpServlet {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/users";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "qwerty007";

    List<User> users;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }

        try {
            UserRepositoryJdbcImpl repositoryJdbc = new UserRepositoryJdbcImpl(
                    DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD)
            );

            users = repositoryJdbc.findAll("registration");
        }
        catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("usersList", users);
        req.getRequestDispatcher("/Jsp/users.jsp").forward(req, resp);
    }
}