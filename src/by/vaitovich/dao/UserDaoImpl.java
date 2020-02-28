package by.vaitovich.dao;

import by.vaitovich.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDaoImpl implements UserDao{

    private static UserDaoImpl INSTANCE;
    private UserDaoImpl(){}
    public static UserDaoImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserDaoImpl();
                }
        return INSTANCE;
    }

    public static final String SAVE_USERS_QUERY = "INSERT INTO users (name, surname, patronymic, address, mail, phone, password, registrationDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String FIND_USERS_QUERY = "SELECT*FROM users";
    public static final String DELETE_USERS_QUERY = "DELETE FROM users WHERE id = ?;";
    public static final String UPDATE_USERS_QUERY ="INSERT INTO users (name, surname, patronymic, address, mail, phone, password, registrationDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


    @Override
      public void saveUser(User user) {

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USERS_QUERY);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getPatronymic());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getMail());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setString(7, user.getPassword());
            preparedStatement.setDate(8, (java.sql.Date) user.getRegistrationDate());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<User> findUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USERS_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(resultSet.getInt("id"),resultSet.getString("surname"), resultSet.getString("name"), resultSet.getString("patronymic"), resultSet.getString("address"), resultSet.getString("mail"), resultSet.getString("phone"), resultSet.getString("password"), resultSet.getDate("registrationDate")));
            }
          preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUsers(User user) {

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_QUERY);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getPatronymic());
            preparedStatement.setString(4, user.getAddress());
            preparedStatement.setString(5, user.getMail());
            preparedStatement.setString(6, user.getPhone());
            preparedStatement.setString(7, user.getPassword());
            preparedStatement.setDate(8, (java.sql.Date) user.getRegistrationDate());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                System.out.println(generatedKeys.getInt(1));
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        @Override
        public void deleteUser(int id) {

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


