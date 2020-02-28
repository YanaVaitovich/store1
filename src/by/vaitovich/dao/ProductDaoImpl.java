package by.vaitovich.dao;

import by.vaitovich.entity.User;
import by.vaitovich.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{

    private static ProductDaoImpl INSTANCE;
    private ProductDaoImpl(){}
    public static ProductDaoImpl getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ProductDaoImpl();
        }
        return INSTANCE;
    }

    public static final String SAVE_PRODUCT_QUERY = "INSERT INTO products (price, oldPrice, title, code, characteristics, brand, datetime, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String FIND_PRODUCT_QUERY = "SELECT*FROM products";
    public static final String DELETE_PRODUCT_QUERY = "DELETE FROM products WHERE id = ?;";
    public static final String UPDATE_PRODUCT_QUERY ="INSERT INTO products (price, oldPrice, title, code, characteristics, brand, datetime, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


    @Override
    public void saveProduct(Product product) {

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_PRODUCT_QUERY);

            preparedStatement.setInt(1, product.getPrice());
            preparedStatement.setInt(2, product.getOldPrice());
            preparedStatement.setString(3, product.getTitle());
            preparedStatement.setString(4, product.getCode());
            preparedStatement.setString(5, product.getCharacteristics());
            preparedStatement.setString(6, product.getBrand());
            preparedStatement.setDate(7, (Date) product.getDatetime());
            preparedStatement.setString(8, product.getDescription());

            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Product> findProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_PRODUCT_QUERY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(new Product());//дозаполнить конструктор
            }
            preparedStatement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void updateProducts(Product product) {

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_QUERY);

            preparedStatement.setInt(1, product.getPrice());
            preparedStatement.setInt(2, product.getOldPrice());
            preparedStatement.setString(3, product.getTitle());
            preparedStatement.setString(4, product.getCode());
            preparedStatement.setString(5, product.getCharacteristics());
            preparedStatement.setString(6, product.getBrand());
            preparedStatement.setDate(7, (Date) product.getDatetime());
            preparedStatement.setString(8, product.getDescription());

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
    public void deleteProduct(int id) {

        try (Connection connection = ConnectionManager.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


