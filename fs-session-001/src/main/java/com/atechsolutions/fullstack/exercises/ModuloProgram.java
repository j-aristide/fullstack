package com.atechsolutions.fullstack.exercises;

import java.util.Scanner;

public class ModuloProgram {
    public static void main(String[] args) {
        // Box A hold 10 items, Box B 5 items, Box C 1 item
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of items purchased: ");
        int numberOfItems = sc.nextInt();

        if(numberOfItems/10 > 0) {
            System.out.println("Placing " + 10 * (numberOfItems/10) + " items in " + (numberOfItems/10) +" Box A(s)");
            numberOfItems = numberOfItems%10;
        }

        if(numberOfItems/5 > 0) {
            System.out.println("Placing " + 5 * (numberOfItems/5) + " items in " + (numberOfItems/5) +" Box B(s)");
            numberOfItems = numberOfItems%5;
        }

        if(numberOfItems > 0) {
            System.out.println("Placing " + numberOfItems + " items in " + numberOfItems +" Box C(s)");
        }
    }
}
