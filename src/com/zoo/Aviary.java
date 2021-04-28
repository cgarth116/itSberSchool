package com.zoo;

import com.zoo.animal.Animal;
import com.zoo.exeption.MessageExeption;
import com.zoo.exeption.NegativeValueExeption;

import java.util.ArrayList;

class Aviary {

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
