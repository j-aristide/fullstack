package com.atechsolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class ProducerConsumer {
    private Random random = new Random();
    private LinkedBlockingQueue<Integer> numbers = new LinkedBlockingQueue<>();

    void chill(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    void produce() {
        synchronized (this) {

                chill(1000);
                numbers.add(random.nextInt(10));
                System.out.println("Just added to producer: " + numbers);
                notify();
        }
    }

    public void consume() {
            synchronized (this) {
                try {


                    chill(500);

                    if (numbers.isEmpty())
                        wait();

                    System.out.println(numbers.take());

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        }
    }

    public static void main(String[] args) throws Exception{
        ProducerConsumer consumer = new ProducerConsumer();

        Thread thread1 = new Thread() {
            public void run() {
                while(true)
                    consumer.consume();
            }
        };

        Thread thread2 = new Thread() {
            public void run() {
                while(true)
                    consumer.produce();
            }
        };

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}