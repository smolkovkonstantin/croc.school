package ru.croc.task10;

import ru.croc.task10.models.LotAtAuction;
import ru.croc.task10.models.User;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Task10 {
    public static void main(String[] args){

        LocalTime endTime = LocalTime.now().plus(10, ChronoUnit.SECONDS);

        System.out.printf("start at %s finish at %s\n", LocalTime.now(), endTime);

        int startBit = 10;

        LotAtAuction lotAtAuction = new LotAtAuction(startBit, endTime);

        lotAtAuction.waitingResults();

        User[] users = new User[10];

        for (int i = 0; i < users.length; i ++){

            users[i] = new User(startBit, String.valueOf(i), lotAtAuction);
            users[i].joinToAuction();

        }
    }
}
