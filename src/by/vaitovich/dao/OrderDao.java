package by.vaitovich.dao;

import by.vaitovich.entity.Order;
import by.vaitovich.entity.Product;
import java.util.List;

public interface OrderDao {

    void saveOrder(Order order);
    void findOrders();
    void updateOrders(Order Order);
    void deleteOrders(int id);
}
