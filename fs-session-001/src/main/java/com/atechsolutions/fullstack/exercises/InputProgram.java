package com.atechsolutions.fullstack.exercises;

import java.util.Scanner;

public class InputProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What is your name?");
        String name = sc.nextLine();

        System.out.println("What is your age?");
        int age = sc.nextInt();


        System.out.println("You entered name: '" + name + "' and age: '" + age + "'");
        if(age >= 16 && age <85)
            System.out.println("Approved");
        else
            System.out.println("Denied");
    }
}
