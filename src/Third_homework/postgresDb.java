package Third_homework;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class postgresDb implements CrudRepository {
    private static final String SQL_SELECT_ALL_FROM_DRIVER = "select * from driver";
    private static final String SQL_SELECT_ALL_FROM_DRIVER_BY_AGE = "select * from driver where age=";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "qwerty007";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/evelina";
    private Connection connection;


    public void createConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now" + "\n");
        } else System.out.println("Failed to make connection to database");

    }

    @Override
    public List<User> findAllByAge(Integer age) {
        List<User> resultAge = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSetAge = statement.executeQuery(SQL_SELECT_ALL_FROM_DRIVER_BY_AGE + age.toString());
            while (resultSetAge.next()) {
                resultAge.add(new User(
                        resultSetAge.getLong("id"),
                        resultSetAge.getString("first_name"),
                        resultSetAge.getString("last_name"),
                        resultSetAge.getInt("age")
                ));
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return resultAge;
    }

    @Override
    public List<User> findAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FROM_DRIVER);

            List<User> result = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age"));
                result.add(user);
            }

            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

}