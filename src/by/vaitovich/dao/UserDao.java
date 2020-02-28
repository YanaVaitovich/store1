package by.vaitovich.dao;

import by.vaitovich.entity.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);
    List<User> findUsers();
    void updateUsers(User user);
    void deleteUser(int id);
}
