package com.atechsolutions;

import java.util.concurrent.atomic.AtomicInteger;

public class IntroToSharingProgram {
    public static void main(String[] args)throws  InterruptedException {
        Counter counter = new Counter();

        Worker akshat = new Worker("Akshat", counter);
        Worker jerome = new Worker("Jerome", counter);
        Worker vladimir = new Worker("Vladimir", counter);

        long start = System.nanoTime();

        akshat.start();
        jerome.start();
        vladimir.start();

        akshat.join();
        jerome.join();
        vladimir.join();

        long end = System.nanoTime();

        System.out.println("Counter total " + counter.value);
        System.out.println("Duration: " + (end-start));
    }
}

class Worker extends Thread {
    private Counter counter;

    Worker(String name, Counter counter) {
        super(name);
        this.counter = counter;
    }

    public void run() {
        for(int i=0; i<1000; i++) {
            counter.increment();
        }
    }
}

class Counter {
    AtomicInteger value = new AtomicInteger(0);

    public void increment() {
        value.incrementAndGet();
    }
}
