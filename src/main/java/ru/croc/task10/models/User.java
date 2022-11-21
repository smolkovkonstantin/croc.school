package ru.croc.task10.models;

import java.time.LocalDateTime;

public class User extends Thread {
    private final String name;
    private final LocalDateTime time;
    private final int bet;

    public User(String name, int bet, LocalDateTime time) {
        this.name = name;
        this.bet = bet;
        this.time = time;
    }

    public void offerBird() {
        start();
    }

    @Override
    public void run() {
        while (LocalDateTime.now().isBefore(time)) {
            try {
                sleep(500);
                // самый богатый дед на свете встаёт со стула
                // самый богатый дед на свете указывает свою ставку
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getNameUser() {
        return name;
    }

    public double getBet() {
        return bet;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", bet=" + bet +
                '}';
    }
}
