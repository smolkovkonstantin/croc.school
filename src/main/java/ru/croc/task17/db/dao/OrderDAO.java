package ru.croc.task17.db.dao;

import ru.croc.task17.db.model.Order;

import java.sql.*;

public class OrderDAO {

    public static void create() {
        try (Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

            final Statement statement = conn.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS order_store " +
                    "(" +
                    "id INTEGER , " +
                    "login_user VARCHAR(255), " +
                    "article  VARCHAR(255) NOT NULL, " +
                    "product_name VARCHAR(255), " +
                    "cost INTEGER" +
                    ")");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addOrder(Order order) {

        try (Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

            final Statement statement = conn.createStatement();

            statement.executeUpdate(String.format("INSERT INTO order_store (%s)" +
                    "VALUES (%s)", Order.getAttribute(), order)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
