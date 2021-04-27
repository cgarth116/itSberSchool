package com.zoo;

import com.zoo.animal.*;
import com.zoo.exeption.*;

import java.util.ArrayList;

public class Zoopark {

    private class Aviary {

        public static final int CAPACITYAVIARY = 10;

        public Aviary() {
            this.name = "New aviary";
            this.capacity = CAPACITYAVIARY;
            this.aviary = new ArrayList();
        }

        public Aviary(String name, int capacity) {
            this();
            this.name = name;
            this.capacity = capacity;
        }

        public void addAnimal(Animal a) throws LowMaxValueExeption, NegativeValueExeption {
            if ((!aviary.isEmpty() && a.getClass() == aviary.get(0).getClass()) || aviary.isEmpty()) {
                if (aviary.contains(a)) {
                    throw new LowMaxValueExeption("The animal is already in the aviary of \"" + this.name + "\"");
                }
                if (this.aviary.size() == this.capacity) {
                    throw new LowMaxValueExeption("The aviary of \"" + this.name + "\" is full");
                }
                this.aviary.add(a);
            } else {
                throw new NegativeValueExeption("type animal vs aviary");
            }
        }

        public void deleteAnimal(Animal a) throws NegativeValueExeption {
            if (!aviary.contains(a)) {
                throw new NegativeValueExeption("There is no such animal in the aviary of \"" + this.name + "\"");
            }
            aviary.remove(a);
        }

        public ArrayList<Animal> getListAnimalIn() {
            return aviary;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSize() {
            return this.aviary.size();
        }

        public int getCapacity() {
            return this.capacity;
        }

        private String              name;
        private int                 capacity;
        private ArrayList<Animal> aviary;
    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String CANTFINDAVIARY = ANSI_PURPLE + " aviary was not found in our Zoo." + ANSI_RESET;
    public static final int    CAPACITYZOO = 10;

    private static void  getMessage(String message){
        System.out.println(message);
    }

    private Aviary  checkAviaryInZoo(String name){
        for (Aviary aviary : this.aviaryZoo) {
            if (aviary.getName() == name) {
                return aviary;
            }
        }
        return null;
    }
    private boolean checkAnimalInAviary(Animal animal, Aviary aviary){
        if (aviary != null && aviary.getListAnimalIn().contains(animal)){
            return true;
        }
        return false;
    }
    public void     addAviary(String name, int capacity) {
        try {
            if (this.aviaryZoo.size() >= this.capacityAviary) {
                throw new NegativeValueExeption("There are no places for aviaries.");
            }
            Aviary aviary = checkAviaryInZoo(name);
            if (aviary != null) {
                throw new NegativeValueExeption("Such an aviary \"" + name + "\" already exists.");
            }
            this.aviaryZoo.add(new Aviary(name, capacity));
        } catch (NegativeValueExeption e) {
            getMessage(e.getMessage());
        }
    }
    public void     delAviary(String name){
        Aviary aviary = checkAviaryInZoo(name);
        try {
            if (aviary == null) {
                throw new NegativeValueExeption(CANTFINDAVIARY);
            }
            //todo we must del animal in deleted aviary for good job
            this.aviaryZoo.remove(aviary);
        } catch (NegativeValueExeption e) {
            getMessage(e.getMessage());
        }
    }
    public void     addAnimalToAviary(Animal animal, String name) {
        Aviary aviary = checkAviaryInZoo(name);
        try {
            if (aviary == null){
                throw new NegativeValueExeption(CANTFINDAVIARY);
            }
            for (Aviary a : aviaryZoo) {
                if (checkAnimalInAviary(animal, a)) {
                    if (a != aviary) {                                          //change aviary for animal
                        a.deleteAnimal(animal);
                        break;
                    } else {                                                    //if animal already in aviary(name)
                        throw new NegativeValueExeption("The animal is already in the aviary");
                    }
                }
            }
            aviary.addAnimal(animal);
        } catch (LowMaxValueExeption | NegativeValueExeption e) {
            getMessage(ANSI_RED + e.getMessage() + ANSI_RESET);
        }
    }
    public void     whoInAviarySays(String name){
        Aviary aviary = checkAviaryInZoo(name);
        if (aviary != null) {
            System.out.println(ANSI_YELLOW + "Let's look who in \"" + aviary.getName() + "\"" + ANSI_RESET);
            for (Animal s : aviary.getListAnimalIn()) {
                s.say();
            }
        } else {
            getMessage(ANSI_RED + "\"" + name + "\"" + ANSI_RESET + CANTFINDAVIARY);
        }
    }

    public Zoopark() {
        this.aviaryZoo = new ArrayList<>(CAPACITYZOO);
    }

    private ArrayList<Aviary>   aviaryZoo;
    private int                 capacityAviary = CAPACITYZOO;




    //help metod
//    public static void whoAviaryInSay(Aviary<? extends Animal> aviary){
//        System.out.println("Let's look who in \"" + aviary.getName() + "\"");
//        for(Animal s: aviary.getListAnimalIn()){
//            s.say();
//        }
//    }
//    public static void lionCheck() throws NegativeValueExeption, LowMaxValueExeption{
//        Lion lion=new Lion("King",12,120);
//        lion.say();
//        lion.eat(10);
//        System.out.println("Lion \""+lion.getName()+"\" eating and he weight: "+lion.getWeight());
//        lion.move(25);
//        System.out.println("Lion \""+lion.getName()+"\" go around and he weight: "+lion.getWeight());
//        lion.sleep(5);
//        System.out.println("Lion \""+lion.getName()+"\" sleep and he weight: "+lion.getWeight());
//        //check no correct input data for test exeption
//        lion.move(-25);
//    }
//    public static void sheepAviaryCheck(Aviary<Sheep> sheepAviary) throws NegativeValueExeption, LowMaxValueExeption {
//        //create some sheep's
//        Sheep sheep1 = new Sheep("1", 3, 71);
//        Sheep sheep2 = new Sheep("2", 4, 72);
//        Sheep sheep3 = new Sheep("3", 5, 73);
//        Sheep sheep4 = new Sheep("4", 4, 74);
//        Sheep sheep5 = new Sheep("5", 3, 75);
//        Sheep sheep6 = new Sheep("6", 4, 76);
//        Sheep sheep7 = new Sheep("7", 4, 72);
//        Sheep sheep8 = new Sheep("8", 4, 73);
//        Sheep sheep9 = new Sheep("9", 4, 71);
//        Sheep sheep10 = new Sheep("10", 4, 71);
//        Sheep sheep11 = new Sheep("11", 4, 68);
//        Sheep sheep12 = new Sheep("12", 4, 70);
//
//        //try add sheep's to aviary
//        sheepAviary.addAnimal(sheep1);
//        sheepAviary.addAnimal(sheep2);
//        sheepAviary.addAnimal(sheep3);
//        sheepAviary.addAnimal(sheep4);
//        sheepAviary.addAnimal(sheep5);
//        sheepAviary.addAnimal(sheep6);
//        sheepAviary.addAnimal(sheep7);
//        sheepAviary.addAnimal(sheep8);
//        sheepAviary.addAnimal(sheep9);
//        sheepAviary.deleteAnimal(sheep3);                                               //delete sheep from aviary
//        sheepAviary.addAnimal(sheep10);
//        sheepAviary.addAnimal(sheep11);
//        sheepAviary.addAnimal(sheep12);
//    }
//    public static void parrotAviaryCheck(Aviary<Parrot> parrotAviary) throws NegativeValueExeption, LowMaxValueExeption {
//        //create some parrot's
//        Parrot parrot1 = new Parrot("Grigorii", 4, 4, "Red");
//        Parrot parrot2 = new Parrot("Popka", 3, 3, "Green");
//        Parrot parrot3 = new Parrot("Kakadu", 4, 7,"Black");
//        Parrot parrot4 = new Parrot("Pirat", 5, 4, "White");
//
//        //try add parrot's to aviary
//        parrotAviary.addAnimal(parrot1);
//        parrotAviary.addAnimal(parrot2);
//        parrotAviary.addAnimal(parrot3);
//        parrotAviary.addAnimal(parrot4);
//    }
//
//    public static void main(String[] args) throws NegativeValueExeption, LowMaxValueExeption {
//        //create some animals and aviary
//        Elephant        elephant = new Elephant("Bor9", 20, 1500);
//        Snake           snake = new Snake("Leather belt", 27, 96);
//        Eagle           eagle = new Eagle("Hawkeye", 11, 14, 10000, 320);
//        Horse           horse = new Horse("Foreigner", 3, 458);
//        //check constructor without parameters
//        Aviary<Parrot>  parrotAviary = new Aviary<Parrot>();
//        //check constructor with parameters
//        Aviary<Sheep>   sheepAviary = new Aviary<Sheep>("Sheep aviary", 10);
//        Aviary<Sheep>   sheepAviarySecond = new Aviary<Sheep>("Sheep 2", 5);
//
//        //check LowMaxValueExeption
//        try{
//            lionCheck();
//        } catch (NegativeValueExeption|LowMaxValueExeption e){
//            System.out.println(e.getMessage());
//        }
//
//        //check aviary with sheep's
//        System.out.println();
//        try{
//            sheepAviaryCheck(sheepAviary);
//        } catch (NegativeValueExeption|LowMaxValueExeption e){
//            System.out.println(e.getMessage());
//        } finally {
//            whoAviaryInSay(sheepAviary);
//        }
//
//        //check aviary with parrot's
//        System.out.println();
//        try{
//            parrotAviaryCheck(parrotAviary);
//        } catch (NegativeValueExeption|LowMaxValueExeption e){
//            System.out.println(e.getMessage());
//        } finally {
//            whoAviaryInSay(parrotAviary);
//        }
//
//        //just listen our animals
//        System.out.println("\nLet's listen another animals");
//        elephant.say();
//        snake.say();
//        eagle.say();
//        horse.say();
//
//
//
//    }
}
