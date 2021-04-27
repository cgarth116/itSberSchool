package com.zoo;

import com.zoo.animal.*;
import com.zoo.exeption.*;

public class Main {

    public static void main(String[] args) throws LowMaxValueExeption, NegativeValueExeption {

        //create our Zoo
        Zoopark ourZoo = new Zoopark();
        Zoopark otherZoo = new Zoopark();

        //create some aviary
        ourZoo.addAviary("Parrot aviary", 3);
        ourZoo.addAviary("Sheep aviary", 10);
        ourZoo.addAviary("Parrot aviary 2", 5);
        ourZoo.addAviary("Parrot aviary", 67);

        //create some aviary
        otherZoo.addAviary("Parrot aviary", 3);
        otherZoo.addAviary("Sheep aviary", 10);
        otherZoo.addAviary("Parrot aviary 2", 5);

        //create some animals
        Parrot  parrot1 = new Parrot("Grigorii", 4, 4, "Red");
        Parrot  parrot2 = new Parrot("Popka", 3, 3, "Green");
        Parrot  parrot3 = new Parrot("Kakadu", 4, 7,"Black");
        Parrot  parrot4 = new Parrot("Pirat", 5, 4, "White");

        Sheep   sheep1 = new Sheep("1", 3, 71);
        Sheep   sheep2 = new Sheep("2", 4, 72);
        Sheep   sheep3 = new Sheep("3", 5, 73);
        Sheep   sheep4 = new Sheep("4", 4, 74);
        Sheep   sheep5 = new Sheep("5", 3, 75);
        Sheep   sheep6 = new Sheep("6", 4, 76);
        Sheep   sheep7 = new Sheep("7", 4, 72);
        Sheep   sheep8 = new Sheep("8", 4, 73);
        Sheep   sheep9 = new Sheep("9", 4, 71);
        Sheep   sheep10 = new Sheep("10", 4, 71);
        Sheep   sheep11 = new Sheep("11", 4, 68);
        Sheep   sheep12 = new Sheep("12", 4, 70);

        System.out.println("Test #1(try to add 4 animals in aviary with capacity 3):");
        ourZoo.addAnimalToAviary(parrot1, "Parrot aviary");
        ourZoo.addAnimalToAviary(parrot2, "Parrot aviary");
        ourZoo.addAnimalToAviary(parrot3, "Parrot aviary");
        ourZoo.addAnimalToAviary(parrot4, "Parrot aviary");
        //let's look who in aviary?
        ourZoo.whoInAviarySays("Parrot aviary");

        System.out.println("\nTest #2(try add animal in aviary with another type):");
        ourZoo.addAnimalToAviary(sheep1, "Parrot aviary");
        //let's look who in aviary?
        ourZoo.whoInAviarySays("Parrot aviary");

        System.out.println("\nTest #3(try add animal in aviary which non in our Zoo):");
        ourZoo.delAviary("Parrot aviary");

        System.out.println("\nTest #4(try to add 4 animals in another aviary with capacity 5):");
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
