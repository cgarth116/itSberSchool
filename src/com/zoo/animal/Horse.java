package com.zoo.animal;

import com.zoo.exeption.*;

public class Horse extends Animal {
    public Horse(String name, int age, float weight) throws MessageExeption {
        super(name, age, weight);
    }
    //method's with different implementation
    protected void  setDefault() {
        //default
        this.weightMin = 13;
        this.weightMax = 666;
        this.ageMax = 47;
        this.sayDefault = "TPRRRuuuuuu.....";
        this.moveCoeff = -0.3;
        this.eatCoeff = 0.3;
        this.sleepCoeff = -0.6;
        this.type = "HORSE";
    }
    public void     say() {
        System.out.println("I'm \"" + this.name + "\" the fastest in the aviary. " + this.getSay());
    }
    public void     setName() {
        this.name = "Horse";
    }

    //unique methods
    public void     Graze(){ System.out.println("I run across the field");}
    public void     goHome() { System.out.println("Going back to the stall");}
}
