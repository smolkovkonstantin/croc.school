package ru.croc.task10.models;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class LotAtAuction extends Thread {

    private static final Object lock = new Object();

    private double price;
    private static String nameOfWinner = "Na blagotvotitelnost";
    private final LocalTime endTime;

    public LotAtAuction(double startPrice, LocalTime endTime) {
        this.price = startPrice;
        this.endTime = endTime;
    }

    public void acceptBid(User user) {
        synchronized (lock) {
            if (user.getBet() > price && user.getTimeOfBet().isBefore(endTime)) {
                nameOfWinner = user.getNameUser();
                price = user.getBet();
            }
        }
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void getWinner() {
        System.out.printf("%s, result: %s\n", nameOfWinner, price);
    }

    // аукцион ждёт до конц (ещё 2 секунды, чтобы вывести ответ в последней строке)
    public void waitingResults() {
        start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(((Math.abs(endTime.getSecond() - LocalDateTime.now().getSecond()) + 1) * 1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        getWinner();
    }
}
