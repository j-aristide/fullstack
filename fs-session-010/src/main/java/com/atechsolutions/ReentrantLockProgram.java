package com.atechsolutions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockProgram {
    public static void main(String[] args)throws InterruptedException {
        Lock lock = new ReentrantLock();

        Accumulator accumulator = new Accumulator();
        ExecutorService service = Executors.newFixedThreadPool(4);

        for(int i=0; i<2500; i++)
            service.execute(new Task(lock, accumulator));

        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
        System.out.println("Accumulated: " + accumulator.value);
    }
}

class Task extends Thread {
    private Lock lock;
    private Accumulator accumulator;

    public Task(Lock lock, Accumulator accumulator) {
        this.lock = lock;
        this.accumulator = accumulator;
    }

    public void run() {
        lock.tryLock();
        try {
            accumulator.increment();
        } finally {
            lock.unlock();
        }
    }
}
class Accumulator {
    int value;

    void increment() {
        value++;
    }
}
