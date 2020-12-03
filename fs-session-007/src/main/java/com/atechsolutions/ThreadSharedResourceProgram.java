package com.atechsolutions;

import java.util.Scanner;

public class ThreadSharedResourceProgram {
    public static void main(String args[]) {
        ProcessorMonitor monitor = new ProcessorMonitor();

        Processor background = new Processor("background", monitor);
        Processor foreground = new Processor("foreground", monitor);

        background.start();
        foreground.start();

        System.out.println("Press Enter to stop the processes: ");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        monitor.shutdown();
    }
}

class Processor extends Thread {
    ProcessorMonitor monitor;

    public Processor(String name, ProcessorMonitor monitor) {
        super(name);
        this.monitor = monitor;
    }

    @Override
    public void run() {
        int counter = 0;
        while (monitor.isRunning()) {
            try {
                Thread.sleep(1000L);
                System.out.printf("Hello from %s X %s\n", Thread.currentThread().getName(), ++counter);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class ProcessorMonitor {
    boolean running = true;

    boolean isRunning() {
        return running;
    }

    void shutdown() {
        System.out.println("Shutting down!!");
        running = false;
    }

}
