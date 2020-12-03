package com.atechsolutions.fullstack.exercises;

import java.io.*;

public class Exception106 {
    public static void main(String[] args)throws Exception {
        // At times it may be necessary to perform some additional operations prior to returning from an exception.  Java provides a feature to allow that.
        // Scenario: A connection may have been established but shortly after an exception is thrown prior to having an opportunity to disconnect
        // using the finally block one can be certain to properly disconnect to a downstream system.

        readAccountInfo("");
    }

    public static void readAccountInfo(String path)throws Exception {
        try {
            connect();
            doStuff();
        }  finally {
            disconnect();
        }
    }

    public static void connect() {
        System.out.println("Connecting");
    }
    public static void disconnect() {
        System.out.println("Disconnecting");
    }

    public static void doStuff()throws Exception {
        System.out.println("About to do something amazing");
        int value = (int)(Math.random() *10);
        System.out.println("value " + value);
        if(value % 2 == 0)
            throw new Exception("Ha ha ha") ;

        System.out.println("Oh yea we did it");
    }
}
