package com.zoo.animal;

import com.zoo.exeption.*;

abstract public class Animal implements Movable, Eatble, Sleepble, Sayble{

    public Animal(String name, int age, float weight) throws MessageExeption{
        this.name = name;
        this.age = age;
        this.weight = weight;

        this.setDefault();

        this.say = sayDefault;
        if (age < 0 || age > this.ageMax || weight < this.weightMin || weight > this.weightMax){
            throw new MessageExeption("Wrong input value!");
        }
    }

    //we must do abstract but they have simple copy\paste realization
    //let's try this option )))
    public String           getName(){
        return this.name;
    }
    protected abstract void setDefault();
    public abstract void    setName();
    public void             setName(String name){
        this.name = name;
    }          //method with different signature
    public int              getAge(){
        return this.age;
    }
    public String           getSay(){
        return this.say;
    }
    public float            getWeight(){
        return this.weight;
    }
    public String           getType() {return this.type; }

    public void             move(float meters) throws NegativeValueExeption, MessageExeption{
        if (meters <= 0){
            throw new NegativeValueExeption("meters!");
        }
        if (this.weight + meters * this.moveCoeff <= this.weightMin){
            this.weight = this.weightMin;
            throw new MessageExeption("I can't move. I need eating.");
        }
        this.weight += meters * this.moveCoeff;
    }
    public void             eat(float kilo) throws NegativeValueExeption, MessageExeption{
        if (kilo <= 0){
            throw new NegativeValueExeption("kilo!");
        }
        if (this.weight + kilo * this.eatCoeff >= this.weightMax){
            this.weight = this.weightMax;
            throw new MessageExeption("I can't eat. I need sleep or move.");
        }
        this.weight += kilo * this.eatCoeff;
    }
    public void             sleep(float hours) throws NegativeValueExeption, MessageExeption {
        if (hours <= 0){
            throw new NegativeValueExeption("hours!");
        }
        if (this.weight + hours * sleepCoeff <= weightMin){
            this.weight = weightMin;
            throw new MessageExeption("I can't sleep. I need eating.");
        }
        this.weight += hours * this.sleepCoeff;
    }

    protected String    name;
    protected int       age;
    protected String    say;
    protected float     weight;

    //default for each animal
    protected float     weightMin;
    protected float     weightMax;
    protected float     ageMax;
    protected String    sayDefault;
    protected double    moveCoeff;
    protected double    eatCoeff;
    protected double    sleepCoeff;
    protected String    type;
}