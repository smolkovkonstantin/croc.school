package ru.croc.task17.db.dao;

import java.sql.*;
import java.util.Calendar;

public class DeliveryDAO {

    public static void update() {

        try (Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

            final Statement statement = conn.createStatement();

            statement.executeUpdate("ALTER TABLE order_store ADD full_name VARCHAR(255)");
            statement.executeUpdate("ALTER TABLE order_store ADD id_delivery INTEGER AUTO_INCREMENT");
            statement.executeUpdate("ALTER TABLE order_store ADD time VARCHAR(255)");


            statement.executeUpdate(
                    String.format("UPDATE order_store SET time='%s', full_name='%s' WHERE id=2",
                            Calendar.getInstance().getTime(), "Вася Пупкин")
            );

            statement.executeUpdate(
                    String.format("UPDATE order_store SET time='%s', full_name='%s' WHERE id=3",
                            Calendar.getInstance().getTime(), "Петя Ивлев")
            );

            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void getCourierInfo(int userId) {
        try (Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

            final Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM order_store WHERE id=%d", userId));

            while (resultSet.next()) {

                System.out.printf("%s %s\n", resultSet.getString("full_name"),
                        resultSet.getString("time"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void getUserInfo(int courierId) {
        try (Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "")) {

            final Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM order_store WHERE id_delivery=%d", courierId));

            while (resultSet.next()) {

                System.out.printf("%s %s %s\n",
                        resultSet.getString("login_user"),
                        resultSet.getString("ARTICLE"),
                        resultSet.getString("PRODUCT_NAME"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
