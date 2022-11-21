package ru.croc.task9;

import ru.croc.task9.bruteforce.BruteForce;
import ru.croc.task9.hash.CreateHash;
import ru.croc.task9.hash.MD5;
import ru.croc.task9.my.reader.MyReader;

public class Task9 {
    public static void main(String[] args) {

        CreateHash hasher = new CreateHash();

        hasher.setHashAlgorithms(new MD5());

        BruteForce bruteForce = new BruteForce();

        String[] countThreadAndHash = MyReader.readTask9(args);

        bruteForce.start(hasher, Integer.parseInt(countThreadAndHash[0]), countThreadAndHash[1]);
    }
}
