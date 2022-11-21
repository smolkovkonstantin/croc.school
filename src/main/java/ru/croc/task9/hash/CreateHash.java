package ru.croc.task9.hash;

/*
    Класс определяет, какой хеш-алгоритм использовать
 */

public class CreateHash {

    Hasher hashAlgorithms;

    public void setHashAlgorithms(Hasher hashAlgorithms){
        this.hashAlgorithms = hashAlgorithms;
    }
    public String getHash(byte[] byteSequence){
        return this.hashAlgorithms.hashPasswordString(byteSequence);
    }
}
