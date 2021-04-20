package com.zoo;

import com.zoo.animal.*;
import java.util.ArrayList;
import java.util.List;

public class Aviary<T> {
        List<T> aviary = new ArrayList<T>();

        public void addAnimal(T a) {
            if (aviary.indexOf(a) >= 0) {
                System.out.println("The animal is already in the aviary.");
            } else {
                this.aviary.add((T) a);
            }
        }

        public void deleteAnimal(T a){
            if (aviary.indexOf(a) < 0) {
                System.out.println("There is no such animal in the aviary of.");
            } else {
                aviary.remove(aviary.indexOf((T) a));
            }
        }
}
