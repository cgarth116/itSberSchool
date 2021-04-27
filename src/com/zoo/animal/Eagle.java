package com.zoo.animal;

import com.zoo.exeption.*;

public class Eagle extends Animal {
    public Eagle(String name, int age, float weight, float maxAttitude, float maxSpeed) throws LowMaxValueExeption {
        super(name, age, weight);
        this.maxAttitude = maxAttitude;
        this.maxSpeed = maxSpeed;
    }
    //method's with different implementation
    protected void  setDefault() {
        //default
        this.weightMin = 11;
        this.weightMax = 47;
        this.ageMax = 15;
        this.sayDefault = "KAAAARRRRrrrrrr.....";
        this.moveCoeff = -0.04;
        this.eatCoeff = 1.2;
        this.sleepCoeff = -0.7;
        this.type = "EAGLE";
    }
    public void     say() {
        System.out.println("I'm \"" + this.name + "\" I see everything around. " + this.getSay());
    }
    public void     setName() {
        this.name = "Eagle";
    }
    //unique methods
    public float    getMaxAttitude(){ return maxAttitude;}
    public float    getMaxSpeed() { return maxSpeed;}

    private float maxAttitude;
    private float maxSpeed;
}
