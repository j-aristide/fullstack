package com.atechsolutions.fullstack.exercises;

/**
 * Conditional Logic using Switch statements
 */
public class SwitchConditionProgram {
    public static void main(String args[]) {
        String name = "Jean";

        switch (name) {
            case "Sowmya" :
                System.out.println("Hello Sowmya, welcome to the class");
                break;
            case "Oybek" :
                System.out.println("Hello Oybek, welcome to the class");
                break;
            case "Jenny" :
                System.out.println("Hello Arisha, welcome to the class");
                break;
            case "Angel" :
                System.out.println("Hello Angel, welcome to the class");
                break;
            case "Nathaniel" :
                System.out.println("Hello Nathaniel, welcome to the class");
                break;
            case "James" :
                System.out.println("Hello James, welcome to the class");
                break;
            case "Sunil" :
                System.out.println("Hello Sunil, welcome to the class");
                break;
            case "Gusmanov" :
                System.out.println("Hello Gusmanov, welcome to the class");
                break;
            case "Santiago" :
                System.out.println("Hello Santiago, welcome to the class");
                break;
            default:
                System.out.println("You are not registered to take this course.");
                break;
        }
    }
}