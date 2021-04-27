package com.zoo;

import com.zoo.animal.*;
import com.zoo.exeption.*;

public class Main {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) throws MessageExeption, NegativeValueExeption {

        //todo good work with some Zoo
        //we have some logical mistakes if we have some Zoo in this realization upssss....
        //don't use animal from one Zoo to another Zoo

        //create our Zoo
        Zoopark ourZoo = new Zoopark();

        //create some aviary
        ourZoo.addAviary("Parrot aviary", 3);
        ourZoo.addAviary("Sheep aviary", 10);
        ourZoo.addAviary("Parrot aviary 2", 5);
        ourZoo.addAviary("Parrot aviary", 67);

        //create some animals
        Parrot  parrot1 = new Parrot("Grigorii", 4, 4, "Red");
        Parrot  parrot2 = new Parrot("Popka", 3, 3, "Green");
        Parrot  parrot3 = new Parrot("Kakadu", 4, 7,"Black");
        Parrot  parrot4 = new Parrot("Pirat", 5, 4, "White");
        Sheep   sheep1 = new Sheep("1", 3, 71);
        Sheep   sheep2 = new Sheep("2", 4, 72);

        System.out.println(ANSI_GREEN + "Test #1(try to add 4 animals in aviary with capacity 3):" + ANSI_RESET);
        ourZoo.addAnimalToAviary(parrot1, "Parrot aviary");
        ourZoo.addAnimalToAviary(parrot2, "Parrot aviary");
        ourZoo.addAnimalToAviary(parrot3, "Parrot aviary");
        ourZoo.addAnimalToAviary(parrot4, "Parrot aviary");
        //let's look who in aviary?
        ourZoo.whoInAviarySays("Parrot aviary");

        System.out.println(ANSI_GREEN + "\nTest #2(try add animal in aviary with another type):" + ANSI_RESET);
        ourZoo.addAnimalToAviary(sheep1, "Parrot aviary");

        System.out.println(ANSI_GREEN + "\nTest #3(try add animal in aviary which non in our Zoo):" + ANSI_RESET);
        ourZoo.addAnimalToAviary(sheep2, "Sheep aviary not our Zoo");

        System.out.println(ANSI_GREEN + "\nTest #4(try to add 4 animals from one to another aviary):" + ANSI_RESET);
        ourZoo.addAnimalToAviary(parrot1, "Parrot aviary 2");
        ourZoo.addAnimalToAviary(parrot2, "Parrot aviary 2");
        ourZoo.addAnimalToAviary(parrot3, "Parrot aviary 2");
        ourZoo.addAnimalToAviary(parrot4, "Parrot aviary 2");
        //let's look who in aviary?
        ourZoo.whoInAviarySays("Parrot aviary 2");
        //let's look who in aviary?
        ourZoo.whoInAviarySays("Parrot aviary");
    }
}
