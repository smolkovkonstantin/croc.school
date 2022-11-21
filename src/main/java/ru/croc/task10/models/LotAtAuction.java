package ru.croc.task10.models;

import java.time.LocalDateTime;

public class LotAtAuction {

    private static final Object lock = new Object();

    private double price;
    private static String nameOfWinner = "Na blagotvotitelnost";
    private final LocalDateTime endTime;

    public LotAtAuction(double startPrice, LocalDateTime endTime) {
        this.price = startPrice;
        this.endTime = endTime;
    }

    public void acceptBid(User user) {
        synchronized (lock) {
            if (user.getBet() > price && user.getTime().isBefore(endTime)) {
                nameOfWinner = user.getNameUser();
                price = user.getBet();
            }
        }
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getWinner() {
        return nameOfWinner;
    }

}
