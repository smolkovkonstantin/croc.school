package ru.croc.task17.db;

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
                    "article  VARCHAR(255), " +
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
                    "VALUES (%s)", Order.getAtribute(), order)
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void drop(){
        try (Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

            final Statement statement = conn.createStatement();

            statement.executeUpdate("DROP TABLE IF EXISTS order_store");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
