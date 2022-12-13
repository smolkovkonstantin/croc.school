package ru.croc.task17.db;

public class Order {

    private int id;
    private String loginUser;
    private String article;
    private String productName;
    private int cost;

    public Order(String id, String loginUser, String article, String productName, String cost) {
        this.id = Integer.parseInt(id);
        this.loginUser = loginUser;
        this.article = article;
        this.productName = productName;
        this.cost = Integer.parseInt(cost);
    }

    public static String getAtribute(){
        return "id, login_user, article, product_name, cost";
    }

    @Override
    public String toString() {
        return String.format("%d, '%s', '%s', '%s', %d", id, loginUser, article, productName, cost);
    }
}
