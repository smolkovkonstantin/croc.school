package ru.croc.task17.exceptions;

public class ProductException extends Exception{
    public ProductException(){
        super("Such a product already exists");
    }
}
