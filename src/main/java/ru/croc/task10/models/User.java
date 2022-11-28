package ru.croc.task10.models;

import java.time.LocalTime;
import java.util.Random;

public class User extends Thread {

    private static final int maxBet = new Random().nextInt(10000);
    private final String name;
    private final LocalTime endTime;
    private LocalTime timeOfBet;
    private int bet;

    private final LotAtAuction lotAtAuction;

    public User(int bet, String name, LotAtAuction lotAtAuction) {
        this.name = name;
        this.endTime = lotAtAuction.getEndTime();
        this.lotAtAuction = lotAtAuction;
        this.bet = bet;
    }

    public void joinToAuction() {
        start();
    }

    // user делает ставку, но не более той суммы, которую имеет
    public void newBet() {

        // мне надоело, что получаются из Math.random и Random не пойми какие числа,
        // поэтому решил сам написать генератор псевдослучайного числа относительно времени

        int someNumber = Math.abs(LocalTime.now().getNano());

        int first = someNumber << new Random().nextInt(17) + 1;
        int second = someNumber << new Random().nextInt(31) + 1;
        int third = someNumber << new Random().nextInt(23) + 1;
        someNumber = Math.abs(someNumber | first | second | third);

        int diffRightandLeft = (maxBet - bet) + 1;
        bet = someNumber % diffRightandLeft + bet;

    }

    // огласка суммы
    public void shoutOutBet(LocalTime time) {
        System.out.printf("%s сделал ставку %s в %s%n", name, bet, time);
    }

    @Override
    public void run() {
        while (LocalTime.now().isBefore(endTime)) {
            newBet();
            shoutOutBet(LocalTime.now());
            timeOfBet = LocalTime.now();

            lotAtAuction.acceptBid(this);

            // user погружается в раздумия
            try {
                Random randomSleep = new Random();
                sleep(4_000 + randomSleep.nextInt(1_000));
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

    public LocalTime getTimeOfBet() {
        return timeOfBet;
    }
}
