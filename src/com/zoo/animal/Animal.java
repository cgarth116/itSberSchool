package com.zoo.animal;

import com.zoo.exeption.*;

abstract public class Animal implements Movable, Eatble, Sleepble, Sayble{

    public Animal(String name, int age, float weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    //default
    protected float    weightMin;
    protected float    weightMax;
    protected float    ageMax;
    protected String   sayDefault;
    protected double   moveCoeff;
    protected double   eatCoeff;
    protected double   sleepCoeff;

    protected String    name;
    protected int       age;
    protected String    say;
    protected float     weight;

    //we can do abstract all metod
    //but why(simple the same type realization)?
    public String           getName(){
        return this.name;
    }
    public abstract void    setName();
    public void             setName(String name){
        this.name = name;
    }
    public int              getAge(){
        return this.age;
    }
    public String           getSay(){
        return this.say;
    }
    public float            getWeight(){
        return this.weight;
    }

    public void move(float meters) throws NegativeValueExeption, LowMaxValueExeption{
        if (meters <= 0){
            throw new NegativeValueExeption("meters!");
        }
        if (this.weight + meters * this.moveCoeff <= this.weightMin){
            this.weight = this.weightMin;
            throw new LowMaxValueExeption("I can't move. I need eating.");
        }
        this.weight += meters * this.moveCoeff;
    }
    public void eat(float kilo) throws NegativeValueExeption, LowMaxValueExeption{
        if (kilo <= 0){
            throw new NegativeValueExeption("kilo!");
        }
        if (this.weight + kilo * this.eatCoeff >= this.weightMax){
            this.weight = this.weightMax;
            throw new LowMaxValueExeption("I can't eat. I need sleep or move." + this.weight + " " +this.weightMin);
        }
        this.weight += kilo * this.eatCoeff;
    }
    public void sleep(float hours) throws NegativeValueExeption, LowMaxValueExeption {
        if (hours <= 0){
            throw new NegativeValueExeption("hours!");
        }
        if (this.weight + hours * sleepCoeff <= weightMin){
            this.weight = weightMin;
            throw new LowMaxValueExeption("I can't sleep. I need eating.");
        }
        this.weight += hours * this.sleepCoeff;
    }
}