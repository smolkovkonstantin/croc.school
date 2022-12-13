package ru.croc.task17.db.dao;

import ru.croc.task17.db.model.Product;
import ru.croc.task17.exceptions.ProductException;

import java.sql.*;
import java.util.List;

public class ProductDAO {

    /**
     * Создаю новую таблицу product с внешним ключом order_id и сразу переношу данные из order_id
     * Удаляю все даныне о продукте из order_store и создаю внетренний ключ product_id и конекчу таблицы
     */

//    public static void create() {
//
//        try (Connection conn = DriverManager.
//                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {
//
//            final Statement statement = conn.createStatement();
//
//            statement.execute("CREATE TABLE IF NOT EXISTS product AS SELECT ARTICLE, PRODUCT_NAME, COST FROM order_store");
//
//            statement.execute("ALTER TABLE order_store DROP COLUMN ARTICLE");
//            statement.execute("ALTER TABLE order_store DROP COLUMN PRODUCT_NAME");
//            statement.execute("ALTER TABLE order_store DROP COLUMN COST");
//
//            statement.executeUpdate("ALTER TABLE order_store ADD product_id INTEGER AUTO_INCREMENT");
//
//            statement.executeUpdate("ALTER TABLE order_store ADD PRIMARY KEY (product_id)");
//
//            statement.executeUpdate("ALTER TABLE product ADD order_id INTEGER AUTO_INCREMENT");
//
//            statement.executeUpdate("ALTER TABLE product ADD PRIMARY KEY (order_id)");
//
//            statement.executeUpdate("ALTER TABLE order_store ADD FOREIGN KEY (product_id) REFERENCES product (order_id)");
//
//
//            statement.close();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
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
