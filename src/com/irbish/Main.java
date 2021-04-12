package com.irbish;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        long    i = 0;
        long    count = 0;
        long    number = 0;
        long    step = 0;
        int     coef= 1;
        Scanner in = new Scanner(System.in);
        long k = in.nextLong();
        //!!! wrong input we do not process !!!

        // check range
        while (count < k) {
            count = count + 9 * powOur(10, i) * (i + 1);
            i++;
            if (i == 18){
                count = Long.MAX_VALUE;
                break;
            }
        }

        //search starting from this number and from this step
        number = powOur(10, i) - 1;
        step = number / 2;

        while (Math.abs(count - k) >= i && step > 0) {
            if (count > k) {
                if (number - step < powOur(10, i - 1)) {
                    step = (number - powOur(10, i - 1)) / 2;
                }
                coef = -1;
            } else {
                if (count < k) {
                    if (number + step > powOur(10, i)) {
                        step = (powOur(10, i) - number) / 2;
                    }
                    coef = 1;
                }
            }
            number += step * coef;
            count += step * i * coef;
            if (step / 2 > 0) {                                             //change step for find
                step /= 2;
            } else {
                step = (step + 1) / 2;
            }
        }

        if (number > 9) {                                                   //if number > 9, bring to conformity to 'k'
            count--;                                                        //decrement first 1
        } else {                                                            //check first nine number
            if (k == 9) {
                System.out.println(1);
            } else {
                System.out.println((k + 1) % 10);
            }
            return;
        }

        if (k == count) {                                                   //found, last digits
            System.out.println(number % 10);
            return;
        }
        if (count - k < 0) {                                                //get number were we need find digits
            number++;
            count += i;
        }
        k = count - k;
        while (k > 0) {                                                     //find our digits
            number /= 10;
            k--;
        }
        System.out.println(number % 10);
        return;
    }

    static long powOur(long base, long exponent){
        long baseTmp = base;
        if (exponent == 0){
            return 1;
        }
        while (--exponent > 0){
            baseTmp = baseTmp * base;
        }
        return baseTmp;
    }
}
