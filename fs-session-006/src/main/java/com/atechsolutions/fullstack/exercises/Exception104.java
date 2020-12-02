package com.atechsolutions.fullstack.exercises;

import java.io.*;

public class Exception104 {
    public static void main(String[] args) {
        readAccountInfo("path to text file here");

        // Java also provides a way to catch a group of exceptions to handle them in a similar fashion within a single catch block
    }

    // Also take note of the stack trace.  The generated stack trace can help diagnose cause for a given error.
    public static void readAccountInfo(String path) {
        try {
            String line;
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
            while ((line = reader.readLine()) != null) {
                System.out.println(line);

            }
        } catch (ArithmeticException | IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}
