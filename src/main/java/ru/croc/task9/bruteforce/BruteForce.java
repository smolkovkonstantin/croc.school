package ru.croc.task9.bruteforce;

import ru.croc.task9.hash.CreateHash;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @fild DEFAULT_LEN - указывает на то, какой длинны закодированное слово
 * @fild bruteForceKit - массив байтов, которой содержит в себе изначально [DEFAULT_LEN]{'a', ... 'a'}
 *
 */


public class BruteForce {

    private static final int DEFAULT_LEN = 7;
    final byte[] bruteForceKit;

    {
        bruteForceKit = new byte[DEFAULT_LEN];
        Arrays.fill(bruteForceKit, (byte) (MIN_VALUE));
    }

    private static final int MAX_VALUE = 'z' + 1;
    private static final int MIN_VALUE = 'a';
    /**
     * Метод start перебирает все символы в bruteForceKit от 'a' до 'z'
     * @param createHash выбранная хешфункция
     * @param hash строка, с которой сравнивается вычисленный хеш
     * @.   Перебор такого типа:
     * @.            a a a ... a
     * @.            b a a ... a
     * @.            c a a ... a
     * @.            ...........
     * @.            a b a ... a
     * @.            b b a ... a
     * @.            ...........
     * @.            a a a ... b
     * @.            ...........
     * @.            z z ..... z
     * @. НО алгоритм немного косячный и какие-то последовательности встречаются несколько раз (~ 1 на 26^6)
     */

    public void start(CreateHash createHash, int countThread, String hash) {
        ExecutorService pool = Executors.newFixedThreadPool(countThread);

        int j = 0;
        for (byte i = MIN_VALUE; i <= MAX_VALUE; i++) {

            // не знаю, что это за конструкция,
            // но idea подсказала так сделать

            byte finalI = i;
            bruteForceKit[bruteForceKit.length - 1] = finalI;
            byte[] bruteForceKitThread = bruteForceKit.clone();

            pool.submit(() -> {
                while (bruteForceKitThread[bruteForceKitThread.length - 2] != MAX_VALUE
                        && bruteForceKitThread[bruteForceKitThread.length - 1] == finalI) {
                    if (mod(bruteForceKitThread[0])) {
                        up(bruteForceKitThread);
                    }

                    String currentHash = createHash.getHash(bruteForceKitThread);

                    if (currentHash.equals(hash)) {
                        System.out.println(new String(bruteForceKitThread, StandardCharsets.UTF_8).toCharArray());
                        // Закодированное слово: passwrd
                    }
                    bruteForceKitThread[0] += 1;
                }
            });
        }
        pool.shutdownNow();
    }

    // при таком значение меньшего разряда повышаем следущий разряд на 1
    public static boolean mod(int first) {
        return first == MAX_VALUE;
    }

    // функция обновляет все разряды в числе
    public void up(byte[] bruteForceKitThread) {
        int i = 0;
        while (mod(bruteForceKitThread[i])) {
            bruteForceKitThread[i] = MIN_VALUE;
            if (i + 1 < bruteForceKitThread.length) {
                bruteForceKitThread[i + 1] += 1;
            } else {
                break;
            }
            i++;
        }
    }
}
