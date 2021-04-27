package com.zoo.animal;

import com.zoo.exeption.*;

interface Movable {
    void move(float meters) throws NegativeValueExeption, MessageExeption;
}
interface Eatble{
    void eat(float kilo) throws NegativeValueExeption, MessageExeption;
}
interface Sleepble{
    void sleep(float hours) throws NegativeValueExeption, MessageExeption;
}
interface Sayble{
    void say();
}
