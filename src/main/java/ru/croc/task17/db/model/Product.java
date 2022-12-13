package ru.croc.task17.db.model;

public class Product {

    private String article;

    private String productName;
    private int cost;

    public Product(String article, String productName, String cost) {
        this.article = article;
        this.productName = productName;
        this.cost = Integer.parseInt(cost);
    }

    public String getArticle() {
        return article;
    }

    public String getAttribute(){
        return "article, product_name, cost";
    }

    @Override
    public String toString() {
        return String.format("'%s', '%s', %d", article, productName, cost);
    }
}
