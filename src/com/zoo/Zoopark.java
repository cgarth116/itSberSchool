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

        public void                 addAnimal(Animal a) throws MessageExeption, NegativeValueExeption {
            if ((!aviary.isEmpty() && a.getClass() == aviary.get(0).getClass()) || aviary.isEmpty()) {
                if (aviary.contains(a)) {
                    throw new MessageExeption("The animal is already in the aviary of \"" + this.name + "\"");
                }
                if (this.aviary.size() == this.capacity) {
                    throw new NegativeValueExeption("The aviary of \"" + this.name + "\" is full");
                }
                this.aviary.add(a);
            } else {
                throw new NegativeValueExeption("type of animal \"" +
                                                a.getClass().getSimpleName() +
                                                "\" but aviary for \"" +
                                                aviary.get(0).getClass().getSimpleName() +
                                                "\"");
            }
        }
        public void                 deleteAnimal(Animal a) throws NegativeValueExeption {
            if (!aviary.contains(a)) {
                throw new NegativeValueExeption("There is no such animal in the aviary of \"" + this.name + "\"");
            }
            aviary.remove(a);
        }
        public ArrayList<Animal>    getListAnimalIn() {
            return aviary;
        }
        public String               getName() {
            return this.name;
        }
        public void                 setName(String name) {
            this.name = name;
        }
        public int                  getSize() {
            return this.aviary.size();
        }
        public int                  getCapacity() {
            return this.capacity;
        }

        private String              name;
        private int                 capacity;
        private ArrayList<Animal>   aviary;
    }

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String CANTFINDAVIARY = " aviary was not found in our Zoo." + ANSI_RESET;
    public static final int    CAPACITYZOO = 10;

    public Zoopark() {
        this.aviaryZoo = new ArrayList<>(CAPACITYZOO);
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
                throw new NegativeValueExeption("\"" + name + "\"" + CANTFINDAVIARY);
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
        } catch (MessageExeption | NegativeValueExeption e) {
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
    private void    getMessage(String message){
        System.out.println(message);
    }

    private ArrayList<Aviary>   aviaryZoo;
    private int                 capacityAviary = CAPACITYZOO;
}
