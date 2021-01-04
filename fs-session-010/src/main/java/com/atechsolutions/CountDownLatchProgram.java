package com.atechsolutions;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class CountDownLatchProgram {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(2);


        prep1(service);
        prep2(service);
        prep3(service);

        //latch.await();
        service.shutdown();
        service.awaitTermination(1, TimeUnit.MINUTES);
        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + (end -start));


    }

    private static void prep1(ExecutorService service) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        List<PreparationTask> task = Arrays.asList(new PreparationTask("Boil water", 1000, latch),
                new PreparationTask("Cutting vegetables", 5000, latch),
                new PreparationTask("Clean chicken", 15000, latch));


        TaskManager taskManager1 = new TaskManager("Step 1", service, task, latch);
        taskManager1.manageTask();
    }

    private static void prep2(ExecutorService service) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);

        List<PreparationTask> task = Arrays.asList(new PreparationTask("Boil Pasta", 10000, latch),
                new PreparationTask("Cook chicken", 20000, latch),
                new PreparationTask("Cook chicken", 5000, latch),
                new PreparationTask("Sautee veggies", 10000, latch));


        TaskManager taskManager1 = new TaskManager("Step 2", service, task, latch);
        taskManager1.manageTask();
    }

    private static void prep3(ExecutorService service) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        List<PreparationTask> task = Arrays.asList(new PreparationTask("Mix", 5000, latch),
                new PreparationTask("Prepare garlic bread", 7500, latch));
        //new PreparationTask("Cook chicken", 5000, latch));


        TaskManager taskManager1 = new TaskManager("Step 3", service, task, latch);
        taskManager1.manageTask();
    }

    static void delay(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}

class TaskManager {
    private String name;
    private List<PreparationTask> tasks;
    private CountDownLatch latch;
    private ExecutorService workers;

    public TaskManager(String name, ExecutorService workers, List<PreparationTask> tasks, CountDownLatch latch) {
        this.name = name;
        this.tasks = tasks;
        this.latch = latch;
        this.workers = workers;
    }

    public void manageTask()throws InterruptedException {
        System.out.printf("TaskManager %s started\n", name);
        long start = System.currentTimeMillis();

        for(PreparationTask task : tasks)
            workers.execute(task);

        latch.await();
        long end = System.currentTimeMillis();
        System.out.printf("TaskManager %s ended time taken %d\n", name, (end - start));

    }
}

class PreparationTask implements Runnable {
    private String task;
    private long timer;
    private CountDownLatch latch;

    public PreparationTask(String task, long timer, CountDownLatch latch) {
        this.task = task;
        this.timer = timer;
        this.latch = latch;
    }

    public void run() {
        System.out.printf("started task: %s\n", task);
        CountDownLatchProgram.delay(timer);
        System.out.printf("completed task: %s.  Time taken %dms\n", task, timer);
        latch.countDown();
    }
}