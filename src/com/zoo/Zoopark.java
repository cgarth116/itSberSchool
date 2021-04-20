package com.zoo;

import com.zoo.animal.*;
import com.zoo.exeption.*;

public class Zoopark {

    public static void lionCheck() throws NegativeValueExeption, LowMaxValueExeption{
            Lion lion=new Lion("King",12,120);
            lion.say();
            lion.eat(10);
            System.out.println("Lion \""+lion.getName()+"\" eating and he weight: "+lion.getWeight());
            lion.move(25);
            System.out.println("Lion \""+lion.getName()+"\" go around and he weight: "+lion.getWeight());
            lion.sleep(5);
            System.out.println("Lion \""+lion.getName()+"\" sleep and he weight: "+lion.getWeight());
            lion.move(-25);
    }

    public static void sheepAviaryCheck() throws NegativeValueExeption, LowMaxValueExeption {
        Aviary<Sheep> sheepAviary = new Aviary<Sheep>();

        Sheep sheep1 = new Sheep("1", 3, 71);
        Sheep sheep2 = new Sheep("2", 4, 72);
        Sheep sheep3 = new Sheep("3", 5, 73);
        Sheep sheep4 = new Sheep("4", 4, 74);
        Sheep sheep5 = new Sheep("5", 3, 75);
        Sheep sheep6 = new Sheep("6", 4, 76);
        Sheep sheep7 = new Sheep("6", 4, 76);
        Horse horse = new Horse("Foreigner", 3, 458);
        //add sheep's to aviary
        sheepAviary.addAnimal(sheep1);
        sheepAviary.addAnimal(sheep2);
        sheepAviary.addAnimal(sheep3);
        sheepAviary.addAnimal(sheep4);
        sheepAviary.addAnimal(sheep5);
        sheepAviary.addAnimal(sheep5);
        sheepAviary.addAnimal(sheep7);
        sheepAviary.addAnimal(sheep6);
        //sheepAviary.addAnimal(horse);
        //delete sheep from aviary
        sheepAviary.deleteAnimal(sheep3);
        //check all sheep's in aviary
        for(Sheep s : sheepAviary.aviary){
            s.say();
        }
    }

    public static void parrotAviaryCheck() throws NegativeValueExeption, LowMaxValueExeption {
        Aviary<Parrot> parrotAviary = new Aviary<Parrot>();

        Parrot parrot1 = new Parrot("Grigorii", 4, 4);
        Parrot parrot2 = new Parrot("Popka", 3, 3);
        Parrot parrot3 = new Parrot("Kakadu", 4, 7);
        Parrot parrot4 = new Parrot("Pirat", 5, 4);

        parrotAviary.addAnimal(parrot1);
        parrotAviary.addAnimal(parrot2);
        parrotAviary.addAnimal(parrot3);
        parrotAviary.addAnimal(parrot4);

        for(Parrot s : parrotAviary.aviary){
            s.say();
        }
    }

    public static void main(String[] args) throws NegativeValueExeption, LowMaxValueExeption {
        //create some animals
        Elephant    elephant = new Elephant("Bor9", 20, 1500);
        Snake       snake = new Snake("Leather belt", 27, 96);
        Eagle       eagle = new Eagle("Hawkeye", 11, 14);
        Horse       horse = new Horse("Foreigner", 3, 458);

        //check LowMaxValueExeption
        try{
            lionCheck();
        } catch (NegativeValueExeption|LowMaxValueExeption e){
            System.out.println(e.getMessage());
        }

        //check aviary with sheep's
        try{
            sheepAviaryCheck();
        } catch (NegativeValueExeption|LowMaxValueExeption e){
            System.out.println(e.getMessage());
        }

        //check aviary with parrot's
        try{
            parrotAviaryCheck();
        } catch (NegativeValueExeption|LowMaxValueExeption e){
            System.out.println(e.getMessage());
        }

        //just listen our animals
        elephant.say();
        snake.say();
        eagle.say();
        horse.say();

    }
}
