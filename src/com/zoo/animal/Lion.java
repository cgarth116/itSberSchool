package com.zoo.animal;

import com.zoo.exeption.*;

public class Lion extends Animal{
    public Lion(String name, int age, float weight) throws MessageExeption {
        super(name, age, weight);
    }
    //method's with different implementation
    protected void  setDefault(){
        //default
        this.weightMin = 50;
        this.weightMax = 550;
        this.ageMax = 57;
        this.sayDefault = "ARRRrrrrr.....";
        this.moveCoeff = -0.1;
        this.eatCoeff = 1;
        this.sleepCoeff = -0.5;
        this.type = "LION";
    }
    public void     say() {
        System.out.println("I'm \"" + this.name + "\" - king of beasts. " + this.getSay());
    }
    public void     setName() {
        this.name = "Lion";
    }

    //unique methods
    public void     Attack(){ System.out.println("I attack you.");}
    public void     Defence() { System.out.println("I defence my pride.");};
}
