package by.vaitovich.dao;
import by.vaitovich.entity.Order;


public class OrderDaoImpl implements OrderDao {

    private static OrderDaoImpl INSTANCE;
    private OrderDaoImpl(){}
    public static OrderDaoImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new OrderDaoImpl();
        }
        return INSTANCE;
    }


    @Override
    public void saveOrder(Order order) {}

     @Override
    public void findOrders() {}

    @Override
    public void updateOrders(Order Order) {}

    @Override
    public void deleteOrders(int id) {}
}
