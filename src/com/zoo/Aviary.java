package com.zoo;

import com.zoo.animal.*;
import com.zoo.exeption.LowMaxValueExeption;

import java.util.ArrayList;
import java.util.List;

public class Aviary<T> {

    public Aviary(){
        this.name = "New aviary";
        this.size = 0;
        this.capacity = 10;
        this.aviary = new ArrayList<T>();
    }
    public Aviary(String name, int capacity){
        this();
        this.name = name;
        this.capacity = capacity;
    }

    public void     addAnimal(T a) throws LowMaxValueExeption {
        if (aviary.indexOf(a) >= 0) {
            throw new LowMaxValueExeption("The animal is already in the aviary of \"" + this.name + "\"");
        }
        if (this.size == this.capacity){
            throw new LowMaxValueExeption("The aviary of \"" + this.name + "\" is full");
        }
        this.aviary.add((T) a);
        this.size++;
    }
    public void     deleteAnimal(T a) throws LowMaxValueExeption{
        if (aviary.indexOf(a) < 0) {
            throw new LowMaxValueExeption("There is no such animal in the aviary of \"" + this.name + "\"");
        }
        aviary.remove(aviary.indexOf((T) a));
        this.size--;
    }
    public List<T>  getListAnimalIn(){
        return aviary;
    }
    public String   getName(){ return  this.name; }
    public void     setName(String name) { this.name = name; }
    public int      getSize() { return this.size; }
    public int      getCapacity() { return this.capacity; }

    private String  name;
    private int     size;
    private int     capacity;
    private List<T> aviary;
}
