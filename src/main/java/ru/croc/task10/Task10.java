package ru.croc.task10;

import ru.croc.task10.models.LotAtAuction;
import ru.croc.task10.models.User;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task10 {
    public static void main(String[] args) {
        System.out.println("start");

        LocalDateTime endTime = LocalDateTime.now().plus(1, ChronoUnit.SECONDS);

        LotAtAuction lot = new LotAtAuction(10, endTime);

        List<User> users = new ArrayList<>();
        int i = 0;
        while(LocalDateTime.now().isBefore(endTime)) {
            Random random = new Random();
            users.add(null);
            users.set(i, new User(
                    Integer.toString(random.nextInt(1000000)), // name
                    random.nextInt(2000), // bet
                    LocalDateTime.now().plus(random.nextInt(5), ChronoUnit.SECONDS) // time of bet
            ));
            System.out.println(users.get(i));

            users.get(i).offerBird();

            lot.acceptBid(users.get(i));

            i += 1;
        }

        System.out.println(lot.getWinner());
        System.out.println(lot.getEndTime());
    }
}
