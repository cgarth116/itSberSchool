package com.irbish;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int lineForDrawing = 0;
        int strLenght = 0;
        int i = 0;
        String spaceBeforeStr = "";
        String spaceAfterStr = "";

        //input data
        Scanner in = new Scanner(System.in);
        Scanner inStr = new Scanner(System.in);
        int lenght = in.nextInt();
        int width = in.nextInt();
        String str = inStr.nextLine();

        //check correctly input data
        //if input string NULL only border present
        strLenght = str.length();
        if ((width < 2 || lenght < 2) ||
                (strLenght != 0 && (width < 3 || lenght < strLenght + 2))){
            System.out.println("Ошибка");
            return;
        }

        //prepare border
        String borderUD = new String(new char[lenght - 2]).replace('\0', ' ');
        String borderLR = "*" + borderUD + "*";
        borderUD = borderLR.replace(' ', '*');
        if (strLenght != 0) {
            spaceBeforeStr = new String(new char[(lenght - 2 - strLenght) / 2]).replace('\0', ' ');
            spaceAfterStr = new String(new char[(lenght - 2 - strLenght + 1) / 2]).replace('\0', ' ');
        } else {
            str = new String(new char[lenght - 2]).replace('\0', ' ');
        }

        //find line for drawing our str
        lineForDrawing = width / 2;
        if (width % 2 == 0){
            lineForDrawing--;
        }

        //draw
        System.out.println(borderUD);
        i = printBorder(0, lineForDrawing, borderLR);
        if (width != 2) {
            System.out.println("*" + spaceBeforeStr + str + spaceAfterStr + "*");
        }
        printBorder(++i, width, borderLR);
        System.out.println(borderUD);
    }

    static int printBorder(int fromLine, int toLine, String str){
        while (++fromLine < toLine){
            System.out.println(str);
        }
        return fromLine;
    }
}
