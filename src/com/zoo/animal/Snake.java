package com.zoo.animal;

import com.zoo.exeption.*;

public class Snake extends Animal {
    public Snake(String name, int age, float weight) throws LowMaxValueExeption{
        super(name, age, weight);

        //default
        this.weightMin = 3;
        this.weightMax = 127;
        this.ageMax = 37;
        this.sayDefault = "TSSssssss.....";
        this.moveCoeff = -0.1;
        this.eatCoeff = 1;
        this.sleepCoeff = -0.5;

        this.say = sayDefault;

        if (age <= 0 || age > this.ageMax || weight < this.weightMin || weight > this.weightMax){
            throw new LowMaxValueExeption("Wrong input value!");
        }
    }

    public void say() {
        System.out.println("I'm \"" + this.name + "\" there is no animal smarter. " + this.getSay());
    }
    public void setName() {
        this.name = "Snake";
    }

}
