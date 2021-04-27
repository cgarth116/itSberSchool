package com.zoo.animal;

import com.zoo.exeption.*;

public class Parrot extends Animal {
    public Parrot(String name, int age, float weight, String color) throws MessageExeption{
        super(name, age, weight);
        this.color = color;
    }
    //method's with different implementation
    protected void  setDefault(){
        //default
        this.weightMin = 1;
        this.weightMax = 15;
        this.ageMax = 23;
        this.sayDefault = "Ass fool .....";
        this.moveCoeff = -0.02;
        this.eatCoeff = 1;
        this.sleepCoeff = -0.02;
        this.type = "PARROT";
    }
    public void     say() {
        System.out.println("I'm \"" + this.name + "\" the most beautiful. " + this.getSay());
    }
    public void     setName() {
        this.name = "Parrot";
    }

    //unique methods
    public void     setSay(String say){
        this.say = say;
    }
    public String   getColor() { return this.color;}

    private String color;
}
