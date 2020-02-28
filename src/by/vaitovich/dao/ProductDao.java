package by.vaitovich.dao;

import by.vaitovich.entity.Product;
import by.vaitovich.entity.User;

import java.util.List;

public interface ProductDao {

    void saveProduct(Product product);
    List<Product> findProducts();
    void updateProducts(Product product);
    void deleteProduct(int id);
}
