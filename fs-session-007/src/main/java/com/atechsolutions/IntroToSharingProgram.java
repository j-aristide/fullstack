package com.atechsolutions;

import java.util.concurrent.atomic.AtomicInteger;

public class IntroToSharingProgram {
    public static void main(String[] args)throws  InterruptedException {
        Resource knife = new Resource();

        Worker arisha = new Worker("Arisha", knife);
        Worker oybek = new Worker("Oybek", knife);
        //Worker jerome = new Worker("Jerome", knife);
        //Worker vladimir = new Worker("Vladimir", knife);

        long start = System.currentTimeMillis();

        arisha.start();
        oybek.start();
        //jerome.start();
        //vladimir.start();

        arisha.join();
        oybek.join();
        //jerome.join();
        //vladimir.join();

        long end = System.currentTimeMillis();

        System.out.println("Counter total " + knife.value);
        System.out.println("Duration: " + (end-start));
    }

    public static void sleep(long value) {
        try {
            Thread.sleep(value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Worker extends Thread {
    private Resource knife;

    Worker(String name, Resource knife) {
        super(name);
        this.knife = knife;
    }

    public void run() {
        for(int i=0; i<1000; i++) {
            //
            knife.increment();
            IntroToSharingProgram.sleep(1L);
            //
        }
    }
}

class Resource {
    AtomicInteger value = new AtomicInteger(0);

    public void increment() {
        IntroToSharingProgram.sleep(10);
        value.incrementAndGet();
    }
}

