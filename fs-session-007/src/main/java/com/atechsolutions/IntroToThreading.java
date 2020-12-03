package com.atechsolutions;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class IntroToThreading {

    public static void main(String args[])throws InterruptedException {
        List<String> students = Arrays.asList("Vladimir", "John", "Nigel", "Logan", "Abraham", "Naomi", "Topher", "Akshat", "Heidi", "Matthew", "Jenny", "Jerome");


        HelloThread runnable1 = new HelloThread("Papi", students);
        runnable1.start();
        runnable1.join();

        System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.println("How now brown cow!");
    }

    static void print(List<String> students, long sleepTime) {
        for(String student : students) {
            try {
                Thread.sleep(sleepTime);
                System.out.printf("Hello, %s -- From %s\n",  student, Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class HelloRunnable implements Runnable {
    private final long sleepTime;
    private final List<String> students;
    public HelloRunnable(List<String> students) {
        this.students = students;
        this.sleepTime = new Random().nextInt(3000);
    }


    @Override
    public void run() {
        IntroToThreading.print(students, sleepTime);
    }
}

class HelloThread extends Thread {
    private final long sleepTime;
    private final List<String> students;
    public HelloThread(String name, List<String> students) {
        super(name);
        this.students = students;
        this.sleepTime = new Random().nextInt(3000);
    }

    @Override
    public void run() {
        IntroToThreading.print(students, sleepTime);
    }
}
