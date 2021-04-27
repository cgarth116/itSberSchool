package com.zoo.animal;

import com.zoo.exeption.*;

public class Elephant extends Animal {
    public Elephant(String name, int age, float weight) throws LowMaxValueExeption{
        super(name, age, weight);
    }
    //method's with different implementation
    protected void  setDefault() {
        //default
        this.weightMin = 1000;
        this.weightMax = 5500;
        this.ageMax = 157;
        this.sayDefault = "VUUuuuuu.....";
        this.moveCoeff = -0.1;
        this.eatCoeff = 0.5;
        this.sleepCoeff = -0.5;
        this.type = "ELEPHANT";
    }
    public void     say() {
        System.out.println("I'm \"" + this.name + "\" the biggest beast. " + this.getSay());
    }
    public void     setName() {
        this.name = "Elephant";
    }
    //unique methods
    public void     waterhole(){ System.out.println("A pond in the savannah");}
    public Elephant giveBirth() throws LowMaxValueExeption {
        Elephant elephant = new Elephant("Bamby", 0, 1400);
        return  elephant;
    }
}
