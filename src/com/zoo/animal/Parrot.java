package com.zoo.animal;

import com.zoo.exeption.*;

public class Parrot extends Animal {
    public Parrot(String name, int age, float weight) throws LowMaxValueExeption{
        super(name, age, weight);

        //default
        this.weightMin = 1;
        this.weightMax = 15;
        this.ageMax = 23;
        this.sayDefault = "Ass fool .....";
        this.moveCoeff = -0.02;
        this.eatCoeff = 1;
        this.sleepCoeff = -0.02;
        this.type = "PARROT";

        this.say = sayDefault;

        if (age <= 0 || age > this.ageMax || weight < this.weightMin || weight > this.weightMax){
            throw new LowMaxValueExeption("Wrong input value!");
        }
    }

    public void say() {
        System.out.println("I'm \"" + this.name + "\" the most beautiful. " + this.getSay());
    }
    public void setName() {
        this.name = "Parrot";
    }

}
