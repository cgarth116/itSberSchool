package com.zoo.animal;

public class Zoo {

    interface Movable{
        void move(float meters);
    }
    interface Eatble{
        void eat(float kilo);
    }
    interface Sleepble{
        void sleep(float hours);
    }
    interface Sayble{
        void say();
    }

    abstract public static class Animals implements Movable, Eatble, Sleepble, Sayble{
       protected String   name;
       protected Integer  age;
       protected String   say;
       protected float    weight;

       public abstract String getName();
       public abstract void setName(String name);
       public abstract Integer getAge();
       public abstract String getSay();
       public abstract float getWeight();

    }

    public static class Lion extends Animals{
        public Lion(String name, Integer age, float weight){
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.say = "i'm lion - arrrrrr.....";
        }

        @Override
        public void move(float meters) {
            this.weight -= meters * 0.01;
        }

        @Override
        public void eat(float kilo) {
            this.weight += kilo;
        }

        @Override
        public void sleep(float hours) {
            this.weight -= hours * 0.5;
        }

        @Override
        public void say() {
            getSay();
        }
        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public void setName(String name) {
            this.name = name;
        }

        @Override
        public Integer getAge() {
            return this.age;
        }

        @Override
        public String getSay() {
            return this.say;
        }

        @Override
        public float getWeight() {
            return this.weight;
        }

    }

    public static void main(String[] args) {
	Animals lion = new Lion("King", 12, 120);
    lion.say();
    }
}
