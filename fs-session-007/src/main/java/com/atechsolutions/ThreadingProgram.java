package com.atechsolutions;

import java.nio.file.WatchService;

public class ThreadingProgram {
    public static void main(String[] args)throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread runner1 = new Thread(new Runner(), "julio");
        Thread runner2 = new Thread(new Runner(), "chavez");

        Thread walking1 = new Walking("mike");
        Thread walking2 = new Walking("tyson");


        walking1.start();
        walking2.start();
        runner2.start();
        runner1.start();

        walking1.join();
        walking2.join();
        runner1.join();
        runner2.join();

        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + (end -start) + " ms");
    }
}

class Walking extends Thread {

    public Walking(String name) {
        super(name);
    }
    @Override
    public void run() {
        for (int i=0; i< 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " Keep walking .....");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Runner implements Runnable {
    @Override
    public void run() {
        for (int i=0; i< 10; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + " Keep running .....");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}