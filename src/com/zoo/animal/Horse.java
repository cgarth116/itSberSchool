package com.zoo.animal;

import com.zoo.exeption.*;

public class Horse extends Animal {
    public Horse(String name, int age, float weight) throws LowMaxValueExeption {
        super(name, age, weight);

        //default
        this.weightMin = 13;
        this.weightMax = 666;
        this.ageMax = 47;
        this.sayDefault = "TPRRRuuuuuu.....";
        this.moveCoeff = -0.3;
        this.eatCoeff = 0.3;
        this.sleepCoeff = -0.6;
        this.type = "HORSE";

        this.say = sayDefault;

        if (age <= 0 || age > this.ageMax || weight < this.weightMin || weight > this.weightMax){
            throw new LowMaxValueExeption("Wrong input value!");
        }
    }

    public void say() {
        System.out.println("I'm \"" + this.name + "\" the fastest in the aviary. " + this.getSay());
    }
    public void setName() {
        this.name = "Horse";
    }

}
