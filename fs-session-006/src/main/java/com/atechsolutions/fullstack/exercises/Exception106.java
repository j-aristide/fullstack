package com.atechsolutions.fullstack.exercises;

import java.io.*;

public class Exception106 {
    public static void main(String[] args) {
        // At times it may be necessary to perform some additional operations prior to returning from an exception.  Java provides a feature to allow that.
        // Scenario: A connection may have been established but shortly after an exception is thrown prior to having an opportunity to disconnect
        // using the finally block one can be certain to properly disconnect to a downstream system.
    }

    public static void readAccountInfo(String path) throws FileNotFoundException, IOException {
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);

            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            System.out.println("Do more stuff");
        }
    }
}
