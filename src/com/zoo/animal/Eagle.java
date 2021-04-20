package com.zoo.animal;

import com.zoo.exeption.*;

public class Eagle extends Animal {
    public Eagle(String name, int age, float weight) throws LowMaxValueExeption {
        super(name, age, weight);

        //default
        this.weightMin = 11;
        this.weightMax = 47;
        this.ageMax = 15;
        this.sayDefault = "KAAAARRRRrrrrrr.....";
        this.moveCoeff = -0.04;
        this.eatCoeff = 1.2;
        this.sleepCoeff = -0.7;
        this.type = "EAGLE";

        this.say = sayDefault;

        if (age <= 0 || age > this.ageMax || weight < this.weightMin || weight > this.weightMax){
            throw new LowMaxValueExeption("Wrong input value!");
        }
    }

    public void say() {
        System.out.println("I'm \"" + this.name + "\" I see everything around. " + this.getSay());
    }
    public void setName() {
        this.name = "Eagle";
    }

}
