package by.vaitovich.dao;

import by.vaitovich.entity.User;

public interface UserDao {

    void findAll(User user);
    void save(User user);

}
