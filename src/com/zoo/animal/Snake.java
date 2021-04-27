package com.zoo.animal;

import com.zoo.exeption.*;

public class Snake extends Animal {
    public Snake(String name, int age, float weight) throws MessageExeption {
        super(name, age, weight);
    }

    //method's with different implementation
    protected void  setDefault() {
        //default
        this.weightMin = 3;
        this.weightMax = 127;
        this.ageMax = 37;
        this.sayDefault = "TSSssssss.....";
        this.moveCoeff = -0.1;
        this.eatCoeff = 1;
        this.sleepCoeff = -0.5;
        this.type = "SNAKE";
    }
    public void     say() {
        System.out.println("I'm \"" + this.name + "\" there is no animal smarter. " + this.getSay());
    }
    public void     setName() {
        this.name = "Snake";
    }

    //unique methods
    public void     baskToSun() {
        System.out.println("Sun it's good");
    }

    public void     toBeHide() {
        System.out.println("Hiding among the stones");
    }
}
