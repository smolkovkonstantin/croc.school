package ru.croc.task17.db.model;

public class Order {

    private int id;
    private String loginUser;
    private Product product;

    public Order(String id, String loginUser, Product product) {
        this.id = Integer.parseInt(id);
        this.loginUser = loginUser;
        this.product = product;
    }

    public static String getAttribute(){
        return "id, login_user, article, product_name, cost";
    }

    @Override
    public String toString() {
        return String.format("%d, '%s', %s", id, loginUser, product);
    }
}
