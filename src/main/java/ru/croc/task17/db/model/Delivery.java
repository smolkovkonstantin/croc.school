package ru.croc.task17.db.model;

import java.sql.Timestamp;

public class Delivery {

    private String fullName;
    private int idDelivery;
    private Timestamp time;

    public Delivery(String fullName, int idDelivery, Timestamp time) {
        this.fullName = fullName;
        this.idDelivery = idDelivery;
        this.time = time;
    }
}
