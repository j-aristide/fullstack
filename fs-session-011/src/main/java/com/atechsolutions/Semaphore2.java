package com.atechsolutions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Semaphore2 {
    public static void main(String[] args)throws InterruptedException {
        RestStop restStop = new RestStop(List.of(new Latrine("uno"), new Latrine("dos"), new Latrine("tres")));

        ExecutorService service = Executors.newFixedThreadPool(10);
        for(int i = 0; i<10; i++) {
            service.execute(new Customer(RandomStringUtils.randomAlphabetic(10), restStop));
        }

        service.awaitTermination(1, TimeUnit.MINUTES);
        service.shutdown();

        System.out.println("All done!!");
    }



}

class RestStop {
    private final Semaphore keys;
    private Collection<Latrine> latrines;

    RestStop(Collection<Latrine> latrines) {
        this.latrines = latrines;
        this.keys = new Semaphore(latrines.size(), true);
    }

    public Latrine requestLatrine()throws InterruptedException {
        keys.acquire();
        synchronized (this) {
            Latrine latrine = findByState(LatrineState.FREE);
            latrine.reserve();
            return latrine;

        }
    }

    public void returnKey() {
        keys.release();
    }

    public Latrine findByState(LatrineState state) {
        return latrines.stream().filter(latrine -> latrine.getState().equals(state)).findFirst().get();
    }
}

class Latrine {
    private String id;
    private LatrineState state = LatrineState.FREE;

    public Latrine(String id) {
        this.id = id;
    }

    public LatrineState getState() {
        return state;
    }

    public void reserve() {
        System.out.println("Reserving latrine " + this + " for customer");
        this.state = LatrineState.RESERVED;
    }

    public void enter() {
        System.out.println("You've been granted access to " + this);
    }

    public void exit() {
        this.state = LatrineState.FREE;
        System.out.println("Latrine is now free");
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("state", state)
                .toString();
    }
}

enum LatrineState {
    FREE, RESERVED;
}

class Customer extends Thread {
    private String name;
    private RestStop restStop;

    public Customer(String name, RestStop restStop) {
        this.name = name;
        this.restStop = restStop;
    }

    @Override
    public void run() {
        try {
            Latrine latrine = restStop.requestLatrine();
            latrine.enter();

            Thread.sleep(5000L);
            System.out.println("Oh, what a relief it is!!!!");
            latrine.exit();
            restStop.returnKey();

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
