package com.atechsolutions;

public class SynchronizedResourceProgram {
    public static void main(String args[]) {
        ProcessorMonitor monitor = new ProcessorMonitor();
        Processor processors[] = new Processor[]{
                new Processor(monitor),
                new Processor(monitor),
                new Processor(monitor)
        };

        long startTime  = System.currentTimeMillis();
        for(int i=0; i<processors.length; i++) {
            try {
                processors[i].start();
                processors[i].join();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }

        long endTime  = System.currentTimeMillis();
        System.out.println(monitor.getExecutionTotal());
        System.out.println("Total time taken " + (endTime - startTime) + "ms");

    }
}

class Processor extends Thread {
    ProcessorMonitor monitor;

    public Processor(ProcessorMonitor monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for(int i=0; i<1000; i++) {
            try {
                Thread.sleep(1L);
                monitor.incrementExecutionCounter();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class ProcessorMonitor {
    int executionCounter;

    public void incrementExecutionCounter() {
        executionCounter++;
    }

    public int getExecutionTotal() {
        return executionCounter;
    }
}
