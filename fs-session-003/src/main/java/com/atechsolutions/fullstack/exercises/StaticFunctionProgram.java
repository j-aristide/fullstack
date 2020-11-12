package com.atechsolutions.fullstack.exercises;

public class StaticFunctionProgram {
    public static void main(String args[]) {
        // Calling a function
        sayHello();


        // Calling a function passing a parameter
        sayHello("Jean", "Aristide");

        // Call a function with a return type
        System.out.printf("What is my change: $%s", giveMeChange(100, 56.98));

    }

    static void sayHello() {
        System.out.println("Hello friend!!!");
    }

    static void sayHello(String firstName, String lastName) {
        System.out.printf("Hello %s %s\n", firstName, lastName);
    }

    static double giveMeChange(double payment, double amountOwed) {
        if(payment < amountOwed)
            System.out.println("Gimme some more.");
        else
            System.out.println("It was nice doing business with you");

        // returning change
        return payment - amountOwed;
    }

}
