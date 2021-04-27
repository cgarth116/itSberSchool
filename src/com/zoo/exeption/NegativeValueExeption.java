package com.zoo.exeption;

public class NegativeValueExeption extends Exception{
    public  NegativeValueExeption(String message){
        super("Negative value: " + message);
    }
}
