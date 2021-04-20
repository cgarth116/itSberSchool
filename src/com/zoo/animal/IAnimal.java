package com.zoo.animal;

import com.zoo.exeption.*;

interface Movable {
    void move(float meters) throws NegativeValueExeption, LowMaxValueExeption;
}
interface Eatble{
    void eat(float kilo) throws NegativeValueExeption, LowMaxValueExeption;
}
interface Sleepble{
    void sleep(float hours) throws NegativeValueExeption, LowMaxValueExeption;
}
interface Sayble{
    void say();
}
