package ru.croc.task17;

import ru.croc.task17.db.dao.ProductDAO;
import ru.croc.task17.db.model.Product;
import ru.croc.task17.exceptions.ProductException;

import java.util.ArrayList;
import java.util.List;

public class Task18 {
    public static void main(String[] args) {

        System.out.println(ProductDAO.findProduct("Т4"));

        System.out.println(ProductDAO.findProduct("Т10"));



        try {
            ProductDAO.createProduct(new Product("T7", "Компьютер", "100000"));
        } catch (ProductException e) {
            throw new RuntimeException(e);
        }

        ProductDAO.deleteProduct("Т5");

        try {
            ProductDAO.createProduct(new Product("T6", "Компьютер", "100000"));
        } catch (ProductException e) {
            throw new RuntimeException(e);
        }

        List<Product> productList = new ArrayList<>(List.of(
                new Product("T10", "10", "10"),
                new Product("T11", "11", "11"),
                new Product("T11", "11", "11")
        ));

        ProductDAO.createOrder("vasya", productList);

    }
}
