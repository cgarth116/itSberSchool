package com.zoo;

import com.zoo.animal.*;
import com.zoo.exeption.*;

import java.util.ArrayList;
import java.util.List;

public class Zoopark {

    //help metod
    public static void whoAviaryInSay(Aviary<? extends Animal> aviary){
        System.out.println("Let's look who in \"" + aviary.getName() + "\"");
        for(Animal s: aviary.getListAnimalIn()){
            s.say();
        }
    }

    public static void lionCheck() throws NegativeValueExeption, LowMaxValueExeption{
        Lion lion=new Lion("King",12,120);
        lion.say();
        lion.eat(10);
        System.out.println("Lion \""+lion.getName()+"\" eating and he weight: "+lion.getWeight());
        lion.move(25);
        System.out.println("Lion \""+lion.getName()+"\" go around and he weight: "+lion.getWeight());
        lion.sleep(5);
        System.out.println("Lion \""+lion.getName()+"\" sleep and he weight: "+lion.getWeight());
        //check no correct input data for test exeption
        lion.move(-25);
    }
    public static void sheepAviaryCheck(Aviary<Sheep> sheepAviary) throws NegativeValueExeption, LowMaxValueExeption {
        //create some sheep's
        Sheep sheep1 = new Sheep("1", 3, 71);
        Sheep sheep2 = new Sheep("2", 4, 72);
        Sheep sheep3 = new Sheep("3", 5, 73);
        Sheep sheep4 = new Sheep("4", 4, 74);
        Sheep sheep5 = new Sheep("5", 3, 75);
        Sheep sheep6 = new Sheep("6", 4, 76);
        Sheep sheep7 = new Sheep("7", 4, 72);
        Sheep sheep8 = new Sheep("8", 4, 73);
        Sheep sheep9 = new Sheep("9", 4, 71);
        Sheep sheep10 = new Sheep("10", 4, 71);
        Sheep sheep11 = new Sheep("11", 4, 68);
        Sheep sheep12 = new Sheep("12", 4, 70);

        //try add sheep's to aviary
        sheepAviary.addAnimal(sheep1);
        sheepAviary.addAnimal(sheep2);
        sheepAviary.addAnimal(sheep3);
        sheepAviary.addAnimal(sheep4);
        sheepAviary.addAnimal(sheep5);
        sheepAviary.addAnimal(sheep6);
        sheepAviary.addAnimal(sheep7);
        sheepAviary.addAnimal(sheep8);
        sheepAviary.addAnimal(sheep9);
        sheepAviary.deleteAnimal(sheep3);                                               //delete sheep from aviary
        sheepAviary.addAnimal(sheep10);
        sheepAviary.addAnimal(sheep11);
        sheepAviary.addAnimal(sheep12);
    }
    public static void parrotAviaryCheck(Aviary<Parrot> parrotAviary) throws NegativeValueExeption, LowMaxValueExeption {
        //create some parrot's
        Parrot parrot1 = new Parrot("Grigorii", 4, 4);
        Parrot parrot2 = new Parrot("Popka", 3, 3);
        Parrot parrot3 = new Parrot("Kakadu", 4, 7);
        Parrot parrot4 = new Parrot("Pirat", 5, 4);

        //try add parrot's to aviary
        parrotAviary.addAnimal(parrot1);
        parrotAviary.addAnimal(parrot2);
        parrotAviary.addAnimal(parrot3);
        parrotAviary.addAnimal(parrot4);
    }

    public static void main(String[] args) throws NegativeValueExeption, LowMaxValueExeption {
        //create some animals and aviary
        Elephant        elephant = new Elephant("Bor9", 20, 1500);
        Snake           snake = new Snake("Leather belt", 27, 96);
        Eagle           eagle = new Eagle("Hawkeye", 11, 14);
        Horse           horse = new Horse("Foreigner", 3, 458);
        //check constructor without parameters
        Aviary<Parrot>  parrotAviary = new Aviary<Parrot>();
        //check constructor with parameters
        Aviary<Sheep>   sheepAviary = new Aviary<Sheep>("Sheep aviary", 10);
        Aviary<Sheep>   sheepAviarySecond = new Aviary<Sheep>("Sheep 2", 5);

        //check LowMaxValueExeption
        try{
            lionCheck();
        } catch (NegativeValueExeption|LowMaxValueExeption e){
            System.out.println(e.getMessage());
        }

        //check aviary with sheep's
        System.out.println();
        try{
            sheepAviaryCheck(sheepAviary);
        } catch (NegativeValueExeption|LowMaxValueExeption e){
            System.out.println(e.getMessage());
        } finally {
            whoAviaryInSay(sheepAviary);
        }

        //check aviary with parrot's
        System.out.println();
        try{
            parrotAviaryCheck(parrotAviary);
        } catch (NegativeValueExeption|LowMaxValueExeption e){
            System.out.println(e.getMessage());
        } finally {
            whoAviaryInSay(parrotAviary);
        }

        //just listen our animals
        System.out.println("\nLet's listen another animals");
        elephant.say();
        snake.say();
        eagle.say();
        horse.say();

    }
}
