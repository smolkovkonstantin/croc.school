package ru.croc.task9.hash;

/*
 Изначально я хотел сделать два преобразователя в кеш: MD5 и SHA-2.
 И для этого использовать паттерн Strategy

 Но сейчас я понял, что не дождался бы, когда для хеша от SHA-2 закончит перебирать
 */

public abstract class Hasher {

    static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
    public byte[] hashPassword(byte[] byteSequence){
        return null;
    }

    public String hashPasswordString(byte[] byteSequence){
        return null;
    }
}
