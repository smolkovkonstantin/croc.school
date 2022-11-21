package ru.croc.task9;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        byte[] bytes = new byte[]{112, 97, 115, 115, 119, 114, 100};
        char[] chars = new String(bytes, StandardCharsets.UTF_8).toCharArray();
        System.out.println(chars);
    }

    public static void brudforce(){
        byte[] bytes = new byte[]{0, 0, 0, 0, 0, 0};
        long a = 0;

        byte mx = 27;
        byte mn = 0;

        for (byte i = mn; i < mx; i++) {

            bytes[bytes.length - 1] = i;

            while (bytes[bytes.length - 2] != mx && bytes[bytes.length - 1] == i) {
                if (mod(bytes[0], mx)) {
                    up(bytes, mx);
                }
                a++;
                System.out.println(Arrays.toString(bytes));
                bytes[0] += 1;
            }
            bytes[0] = 0;
        }
        System.out.println(a);
    }

    public static boolean mod(int a, int ost) {
        return a % ost == 0 && a > 0;
    }

    public static void up(byte[] bytes, int ost) {
        int i = 0;
        while (mod(bytes[i], ost)) {
            bytes[i] = 0;
            if (i + 1 < bytes.length) {
                bytes[i + 1] += 1;
            } else {
                break;
            }
            i++;
        }
    }
}
