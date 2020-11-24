package com.atechsolutions.fullstack.exercises;

import java.util.concurrent.LinkedBlockingQueue;

public class QueueExerciseProgram {
    public static void main(String args[]) {
        LinkedBlockingQueue values = new LinkedBlockingQueue();
        values.add("January");
        values.add("February");
        values.add("March");
        values.add("April");
        values.add("May");
        values.add("June");
        values.add("July");
        values.add("August");
        values.add("September");
        values.add("October");
        values.add("November");
        values.add("December");

        // Exception Handling to be covered in future session
        try {
            System.out.println(values.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for(Object value : values) {
            System.out.println("Looping through: " + value);
        }
    }
}
