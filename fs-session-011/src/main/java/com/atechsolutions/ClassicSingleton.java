package com.atechsolutions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ClassicSingleton {
    private String name = RandomStringUtils.randomAlphabetic(10);
    private volatile static ClassicSingleton singleton;

    public static ClassicSingleton getInstance() {
        if(singleton == null) {
            /////
            synchronized (ClassicSingleton.class) {
                if(singleton == null) {
                    singleton = new ClassicSingleton();
                }
            }
        }

        return singleton;
    }

    public static void main(String[] args)throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        IntStream.range(0, 10).forEach(i -> service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(ClassicSingleton.getInstance());
            }
        }));

        service.awaitTermination(1, TimeUnit.MINUTES);
        service.shutdownNow();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .toString();
    }
}
