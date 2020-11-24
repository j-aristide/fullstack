package com.atechsolutions.fullstack.exercises;

import java.util.Stack;

public class StackExerciseProgram {
    public static void main(String args[]) {
        Stack<String> stack = new Stack<>();
        stack.push("December");
        stack.push("November");
        stack.push("October");
        stack.push("September");
        stack.push("August");
        stack.push("July");
        stack.push("June");
        stack.push("May");
        stack.push("April");
        stack.push("March");
        stack.push("February");
        stack.push("January");

        System.out.println("What is the size of the stack? " + stack.size());
        System.out.println("Which month gets pushed next? " + stack.peek());
        System.out.println("Pop last pushed item: " + stack.pop());

        System.out.println("What is the size of the stack? " + stack.size());
        System.out.println("Which month gets pushed next? " + stack.peek());
        System.out.println("Pop last pushed item: " + stack.pop());

        for(String value : stack) {
            System.out.println("Looping through: " + value);
        }

        System.out.println(stack.size());
    }
}
