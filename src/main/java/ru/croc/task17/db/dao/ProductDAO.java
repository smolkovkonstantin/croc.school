package ru.croc.task17.db.dao;

import ru.croc.task17.db.model.Product;
import ru.croc.task17.exceptions.ProductException;

import java.sql.*;
import java.util.List;

public class ProductDAO {

    public static Product findProduct(String productCode) {

        Product result = null;

        try (Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

            final Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(
                    String.format("SELECT * FROM order_store WHERE ARTICLE = '%s'", productCode)
            );

            if (resultSet.next()) {
                result = new Product(
                        resultSet.getString("article"),
                        resultSet.getString("product_name"),
                        resultSet.getString("cost")
                );
            }

            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static void createProduct(Product product) throws ProductException {
        if (findProduct(product.getArticle()) != null) {
            throw new ProductException();
        }

        try (Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

            final Statement statement = conn.createStatement();

            statement.executeUpdate(String.format("INSERT INTO order_store (%s)" +
                    "VALUES (%s)", product.getAttribute(), product)
            );

            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void updateProduct(Product product) {

        try (Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

            final Statement statement = conn.createStatement();

            statement.executeUpdate(String.format("SELECT * FROM order_store WHERE article = '%s'", product.getArticle()));

            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteProduct(String productCode) {

        try (Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

            final Statement statement = conn.createStatement();

            statement.executeUpdate(String.format("DELETE FROM order_store WHERE ARTICLE = '%s'", productCode));

            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createOrder(String loginUser, List<Product> productList) {

        try (Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

            final Statement statement = conn.createStatement();

            for (Product product : productList) {
                statement.execute(String.format(
                        "INSERT INTO order_store (login_user, %s) VALUES ('%s', %s)",
                        product.getAttribute(), loginUser, product)
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
