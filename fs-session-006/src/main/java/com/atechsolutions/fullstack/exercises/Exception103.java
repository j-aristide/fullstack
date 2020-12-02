package com.atechsolutions.fullstack.exercises;

import java.io.*;

public class Exception103 {
    public static void main(String[] args) {
        // Exploring Exception precedence

        // Another to handle checked exceptions is to catch them
        // In order to catch an exception it must be within a try block followed by a catch block with the type of exception being caught explicitly mentioned.

        // Notice the order in which the exceptions are being caught and try to catch IOException before FileNotFoundException

        readAccountInfo("path to text file here");
    }

    public static void readAccountInfo(String path) {
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
        }
    }
}
