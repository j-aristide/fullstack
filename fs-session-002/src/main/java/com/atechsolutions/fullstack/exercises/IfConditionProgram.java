package com.atechsolutions.fullstack.exercises;

/**
 * Conditional logic with if and if-else
 */
public class IfConditionProgram {
    public static void main(String args[]) {
        // If Conditions
        if (true)
            System.out.println("Hello World!!");

        // If/Else
        System.out.println();
        int a = 5;

        if (a > 5)
            System.out.println("It's bigger");
        else
            System.out.println(("It's smaller"));

        //If/Else If
        System.out.println();
        if (a > 5)
            System.out.println("It's bigger");
        else if (a < 5)
            System.out.println(("It's smaller"));
        else
            System.out.println("It's the same");


        //More than one statement after the if  -- use braces
        System.out.println();
        if (a > 5) {
            System.out.println("If 'statement");
            System.out.println("It's bigger");
        } else if (a < 5) {
            System.out.println(("Else if statement"));
            System.out.println(("It's smaller"));
        } else {
            System.out.println(("Else statement"));
            System.out.println("It's the same");
        }

    }
}