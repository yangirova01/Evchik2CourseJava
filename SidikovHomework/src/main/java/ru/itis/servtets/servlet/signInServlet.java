package ru.itis.servtets.servlet;

import ru.itis.servtets.model.User;
import ru.itis.servtets.repositories.CookieRepositoryImpl;
import ru.itis.servtets.repositories.UserRepository;
import ru.itis.servtets.repositories.UserRepositoryJdbcImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;
import java.util.UUID;

@WebServlet("/signIn")
public class signInServlet extends HttpServlet {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/users";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "qwerty007";

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            userRepository = new UserRepositoryJdbcImpl(connection);
        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/html/signIn.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("email");
        String pass = request.getParameter("password");

        Optional<User> currentUser = userRepository.findByLogin(login, "registration");

        if(currentUser.isPresent()) {
            if(
                    currentUser.get().getEmail().equals(login) &&
                    currentUser.get().getPassword().equals(pass)
            ) {
                CookieRepositoryImpl cookieRepository = new CookieRepositoryImpl(response);
                cookieRepository.addCookie(UUID.randomUUID().toString(), currentUser.get().getId());
                response.sendRedirect("/users");
            }
            else {
                response.sendRedirect("/signIn");
            }
        }
        else {
            response.sendRedirect("/singIn");
        }


    }

}