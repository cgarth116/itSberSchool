package com.zoo.animal;

import com.zoo.exeption.*;

public class Lion extends Animal{
    public Lion(String name, int age, float weight) throws LowMaxValueExeption {
        super(name, age, weight);

        //default
        this.weightMin = 50;
        this.weightMax = 550;
        this.ageMax = 57;
        this.sayDefault = "ARRRrrrrr.....";
        this.moveCoeff = -0.1;
        this.eatCoeff = 1;
        this.sleepCoeff = -0.5;

        this.say = sayDefault;

        if (age <= 0 || age > this.ageMax || weight < this.weightMin || weight > this.weightMax){
            throw new LowMaxValueExeption("Wrong input value!");
        }
    }

    public void say() {
        System.out.println("I'm \"" + this.name + "\" - king of beasts. " + this.getSay());
    }
    public void setName() {
        this.name = "Lion";
    }

}
