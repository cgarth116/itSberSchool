package com.zoo.animal;

import com.zoo.exeption.*;

public class Elephant extends Animal {
    public Elephant(String name, int age, float weight) throws LowMaxValueExeption{
        super(name, age, weight);

        //default
        this.weightMin = 1000;
        this.weightMax = 5500;
        this.ageMax = 157;
        this.sayDefault = "VUUuuuuu.....";
        this.moveCoeff = -0.1;
        this.eatCoeff = 0.5;
        this.sleepCoeff = -0.5;
        this.type = "ELEPHANT";

        this.say = sayDefault;

        if (age <= 0 || age > this.ageMax || weight < this.weightMin || weight > this.weightMax){
            throw new LowMaxValueExeption("Wrong input value!");
        }
    }

    public void say() {
        System.out.println("I'm \"" + this.name + "\" the biggest beast. " + this.getSay());
    }
    public void setName() {
        this.name = "Elephant";
    }
}
