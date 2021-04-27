package com.zoo.animal;

import com.zoo.exeption.*;

public class Sheep extends Animal {
    public Sheep(String name, int age, float weight) throws LowMaxValueExeption{
        super(name, age, weight);
    }
    //method's with different implementation
    protected void  setDefault() {
        //default
        this.weightMin = 10;
        this.weightMax = 255;
        this.ageMax = 17;
        this.sayDefault = "BEEEeeeeee.....";
        this.moveCoeff = -0.05;
        this.eatCoeff = 1.5;
        this.sleepCoeff = -0.03;
        this.type = "SHEEP";
    }
    public void     say() {
        System.out.println("I'm \"" + this.name + "\" we go in a herd. " + this.getSay());
    }
    public void     setName() {
        this.name = "Sheep";
    }

    //unique methods
    public void     toBeAfraid(){ System.out.println("We afraid you.");}
    public void     tiBeDefence() { System.out.println("We defence our.");}
}
