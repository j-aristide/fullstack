package com.atechsolutions;

import java.util.Scanner;

public class ThreadVolatileProgram {
    volatile boolean running =true;

    public void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                while(running) {
                    counter++;
                }
                System.out.println("Thread 1 finished. Counted up to " + counter);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hit Enter to stop");
                Scanner scanner = new Scanner(System.in);
                scanner.nextLine();

                System.out.println("Thread 2 finished. Setting running state to false");
                running = false;
            }
        }).start();
    }
    public static void main(String[] args) {
        ThreadVolatileProgram program = new ThreadVolatileProgram();
        program.test();
    }
}
