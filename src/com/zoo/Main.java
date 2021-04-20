package com.zoo;

import com.zoo.animal.*;
import com.zoo.exeption.*;

public class Main {
    public static void main(String[] args) throws NegativeValueExeption, LowMaxValueExeption {
        try {
            Lion lion = new Lion("King", 12, 120);
            lion.say();
            lion.eat(10);
            System.out.println("Lion \"" + lion.getName() + "\" eating and he weight: " + lion.getWeight());
            lion.move(25);
            System.out.println("Lion \"" + lion.getName() + "\" go around and he weight: " + lion.getWeight());
            lion.sleep(5);
            System.out.println("Lion \"" + lion.getName() + "\" sleep and he weight: " + lion.getWeight());
            lion.move(-25);
        }
        catch (NegativeValueExeption | LowMaxValueExeption e) {
            System.out.println(e.getMessage());
        }

        Elephant elephant = new Elephant("Bor9", 20, 1500);
        Sheep sheep = new Sheep("", 3, 70);
        Snake snake = new Snake("Leather belt", 27, 96);
        Eagle eagle = new Eagle("Hawkeye", 11, 14);
        Horse horse = new Horse("Foreigner", 3, 458);
        Parrot parrot = new Parrot("Grigorii", 4, 2);

        elephant.say();
        sheep.setName();
        sheep.say();
        snake.say();
        eagle.say();
        horse.say();
        parrot.say();
    }
}
