package by.vaitovich.dao;

import by.vaitovich.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl {
    public static final String FIND_ALL_USERS_QUERY = "SELECT*FROM users";
    public static final String SAVE_USERS_QUERY = "INSERT INTO users (surname, name) VALUES (?, ?)";

    public List<User> save() {
        List<User> users = new ArrayList<>();

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USERS_QUERY);



            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_USERS_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"),resultSet.getString("surname"), resultSet.getString("name")));
            }
          preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
